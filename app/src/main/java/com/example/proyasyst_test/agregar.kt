package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.proyasyst_test.databinding.ActivityAgregarBinding
import com.example.proyasyst_test.databinding.ActivityBasededatosBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.database.sqlite.SQLiteDatabase

class agregar : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarBinding
    private lateinit var alarmasBdHelper: miSQLiteHelper
    var d1 = 0
    var d2 = 0
    var d3 = 0
    var d4 = 0
    var d5 = 0
    var d6 = 0
    var d7 = 0
    var d8 = 0
    var d9 = 0
    var d10 = 0
    var d11 = 0
    var d12 = 0
    var d13 = 0
    var d14 = 0
    var d15 = 0
    var d16 = 0
    var d17 = 0
    var d18 = 0
    var d19 = 0
    var d20 = 0
    var d21 = 0
    var d22 = 0
    var d23 = 0
    var d24 = 0
    var tipoAlarma = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        ///////////////////////////////////////////////////////////////////////////////////////////

        binding = ActivityAgregarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fecha = findViewById<TextView>(R.id.FechaEstatica)
        val txtMedicamento = findViewById<EditText>(R.id.txtMedic)
        val txtIntervaloMedicamento = findViewById<EditText>(R.id.txtHoras)
        val txteridoTratamiento = findViewById<EditText>(R.id.txtDias)

        val estado = 1


        val alarmasBdHelper = miSQLiteHelper(this)
        val calendar = Calendar.getInstance()
        val fechaActual = calendar.time
        val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaFormateada = formatoFecha.format(fechaActual)

        fecha.text = fechaFormateada
        fecha.text = fecha.text.toString()

        /////////////////////////////////////////////////////////////////////////////////////////////

        val btnCancelar = findViewById<ImageButton>(R.id.btnCancelar)
        btnCancelar.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
        }

        val btnSwich = findViewById<Switch>(R.id.switchAgregar)
        var modoEstrictoActivado = false // Variable para mantener el estado del modo estricto
        btnSwich.setOnClickListener {
            val alerta = AlertDialog.Builder(this)

            alerta.setMessage("Este modo está diseñado para brindar apoyo las 24 horas a partir del lapso especificado")
                .setCancelable(false)
                .setPositiveButton("Sí") { dialog, which ->
                    modoEstrictoActivado = true
                    startActivity(Intent(this, Estricto::class.java))
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    finish()
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                    btnSwich.isChecked = modoEstrictoActivado // Restablecer el estado del Switch
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas activar el modo estricto?")
            titulo.show()
        }

        binding.btnAgregar.setOnClickListener {

            if (txtMedicamento.text.isNotBlank() &&
                txtIntervaloMedicamento.text.isNotBlank() &&
                txteridoTratamiento.text.isNotBlank()
                && txtIntervaloMedicamento.text.toString().toInt() > 0
                && txteridoTratamiento.text.toString().toInt() > 0)
            {
                if(txtIntervaloMedicamento.text.toString().toInt() <= 5 && txtIntervaloMedicamento.text.toString().toInt() > 0){
                    if(txtIntervaloMedicamento.text.toString().toInt() == 1){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            1,
                            //colocar aqui el tipo de alarma
                             0,
                            d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, 1, d14, d15, d16,d17, d18, d19, d20, d21,
                            d22, d23, d24)
                        //Limpia todos los campos
                        txtMedicamento.text.clear()
                        txtIntervaloMedicamento.text.clear()
                        txteridoTratamiento.text.clear()
                        Toast.makeText(this, "El dato ah sido guardado", Toast.LENGTH_SHORT).show()
                    }else if(txtIntervaloMedicamento.text.toString().toInt() == 2){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            1,
                            0,
                            d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, 1, d12, 0, d14, d15, d16,d17, d18, d19, d20, d21,
                            d22, 1, d24)
                        //Limpia todos los campos
                        txtMedicamento.text.clear()
                        txtIntervaloMedicamento.text.clear()
                        txteridoTratamiento.text.clear()
                        Toast.makeText(this, "El dato ah sido guardado", Toast.LENGTH_SHORT).show()

                    }else if(txtIntervaloMedicamento.text.toString().toInt() == 3){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            1,
                            0,
                            d1, d2, d3, d4, d5, d6, d7, d8, 1, d10, d11,d12, d13, d14, d15, 1,d17, d18, d19, d20, d21,
                            1, d23, d24)
                        //Limpia todos los campos
                        txtMedicamento.text.clear()
                        txtIntervaloMedicamento.text.clear()
                        txteridoTratamiento.text.clear()
                        Toast.makeText(this, "El dato ah sido guardado", Toast.LENGTH_SHORT).show()

                    }else if(txtIntervaloMedicamento.text.toString().toInt() == 4){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            1,
                            0,
                            d1, d2, d3, d4, d5, d6, d7, d8, 1, d10, d11,d12, 1, d14, d15, d14 ,1, d18, d19, d20, 1,
                            d22, d23, d24)
                        //Limpia todos los campos
                        txtMedicamento.text.clear()
                        txtIntervaloMedicamento.text.clear()
                        txteridoTratamiento.text.clear()
                        Toast.makeText(this, "El dato ah sido guardado", Toast.LENGTH_SHORT).show()

                    }else if(txtIntervaloMedicamento.text.toString().toInt() == 5){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            1,
                            0,
                            d1, d2, d3, d4, d5, d6, d7, d8, 1, d10, d11,1, d13, d14, 1, d16,d17, 1, d19, d20, 1,
                            d22, d23, d24)
                        //Limpia todos los campos
                        txtMedicamento.text.clear()
                        txtIntervaloMedicamento.text.clear()
                        txteridoTratamiento.text.clear()
                        Toast.makeText(this, "El dato ah sido guardado", Toast.LENGTH_SHORT).show()}
                }else {
                    Toast.makeText(this, "El numero maximo tiene que 5 ",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(this, "Los campos estan vacios, por favor rellenelos", Toast.LENGTH_SHORT).show()
            }
        }


    }
}