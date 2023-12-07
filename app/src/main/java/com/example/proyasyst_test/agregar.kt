package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.proyasyst_test.databinding.ActivityAgregarBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class agregar : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarBinding
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


        val alarmasBdHelper = DatabaseHelper(this)
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

            if (binding.txtMedic.text.isNotBlank() &&
                binding.txtHoras.text.isNotBlank() &&
                binding.txtDias.text.isNotBlank())
            {

                    alarmasBdHelper.anadirDato(
                        fecha.text.toString(),
                        txtMedicamento.text.toString(),
                        txtIntervaloMedicamento.text.toString().toInt(),
                        txteridoTratamiento.text.toString().toInt(),
                        0)

                //Limpia todos los campos
                binding.txtMedic.text.clear()
                binding.txtHoras.text.clear()
                binding.txtDias.text.clear()
                Toast.makeText(this, "El dato ah sido guardado", Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(this, "Los campos estan vacios, por favor rellenelos", Toast.LENGTH_SHORT).show()
            }

        }


    }
}