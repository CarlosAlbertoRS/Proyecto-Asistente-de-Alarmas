package com.example.proyasyst_test

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.proyasyst_test.databinding.ActivityBasededatosBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class basededatos : AppCompatActivity() {
    private lateinit var binding: ActivityBasededatosBinding
    private lateinit var alarmasBdHelper: miSQLiteHelper
    private var id = 0
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
    var d21 = 1
    var d22 = 0
    var d23 = 0
    var d24 = 0
    var tipoAlarma = 0

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basededatos)

        binding = ActivityBasededatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fecha = findViewById<TextView>(R.id.fecha)
        val txtMedicamento = findViewById<TextView>(R.id.txtMedicamento)
        val txtIntervaloMedicamento = findViewById<TextView>(R.id.txtPeriodoDeTiempo)
        val txteridoTratamiento = findViewById<TextView>(R.id.txtPeriodoDeTratamiento)
        val txtId2 = findViewById<TextView>(R.id.txtId2)
        val txtMedicamentoActualizar2 = findViewById<TextView>(R.id.txtMedicamentoActualizar2)
        val btnEliminarregistro = findViewById<Button>(R.id.btnEliminarregistro)
        val btnActualiarregistro = findViewById<Button>(R.id.btnActualiarregistro)
        val estado = 1



        val alarmasBdHelper = miSQLiteHelper(this)
        val calendar = Calendar.getInstance()
        val fechaActual = calendar.time
        val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaFormateada = formatoFecha.format(fechaActual)

        fecha.text = fechaFormateada


        fecha.text = fecha.text.toString()
        binding.btnAgregarDatos.setOnClickListener {

            if (binding.txtMedicamento.text.isNotBlank() &&
                binding.txtPeriodoDeTiempo.text.isNotBlank() &&
                binding.txtPeriodoDeTratamiento.text.isNotBlank())
            {
                if(binding.txtPeriodoDeTiempo.toString().toInt() <= 5 && binding.txtPeriodoDeTiempo.toString().toInt() > 0){
                    if(binding.txtPeriodoDeTiempo.toString().toInt() == 1){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            estado = 1,
                            //colocar aqui el tipo de alarma
                            tipoAlarma,
                            d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, 1, d14, d15, d16,d17, d18, d19, d20, d21,
                            d22, d23, d24)
                    }else if(binding.txtPeriodoDeTiempo.toString().toInt() == 2){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            estado = 1,
                            tipoAlarma,
                            d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, 1, d12, 0, d14, d15, d16,d17, d18, d19, d20, d21,
                            d22, 1, d24)

                    }else if(binding.txtPeriodoDeTiempo.toString().toInt() == 3){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            estado = 1,
                            tipoAlarma,
                            d1, d2, d3, d4, d5, d6, d7, d8, 1, d10, d11,d12, d13, d14, d15, 1,d17, d18, d19, d20, d21,
                            1, d23, d24)

                    }else if(binding.txtPeriodoDeTiempo.toString().toInt() == 4){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            estado = 1,
                            tipoAlarma,
                            d1, d2, d3, d4, d5, d6, d7, d8, 1, d10, d11,d12, 1, d14, d15, d14 ,1, d18, d19, d20, 1,
                            d22, d23, d24)

                    }else if(binding.txtPeriodoDeTiempo.toString().toInt() == 5){
                        alarmasBdHelper.anadirDato2(
                            fecha.text.toString(),
                            txtMedicamento.text.toString(),
                            txtIntervaloMedicamento.text.toString().toInt(),
                            txteridoTratamiento.text.toString().toInt(),
                            estado = 1,
                            tipoAlarma,
                            d1, d2, d3, d4, d5, d6, d7, d8, 1, d10, d11,1, d13, d14, 1, d16,d17, 1, d19, d20, 1,
                            d22, d23, d24)                    }
                }else {
                    Toast.makeText(this, "El numero maximo tiene que 5 ",Toast.LENGTH_SHORT).show()
                }

                //binding.fecha.text.toString(),
                //binding.txtMedicamento.text.toString(),
                //binding.txtPeriodoDeTiempo.text.toString().toInt(),
                //binding.txtPeriodoDeTratamiento.text.toString().toInt(),
                //binding.switchEstad.text.toString().toInt())


                //Limpia todos los campos
                binding.txtMedicamento.text.clear()
                binding.txtPeriodoDeTiempo.text.clear()
                binding.txtPeriodoDeTratamiento.text.clear()
                Toast.makeText(this, "El dato ah sido guardado", Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(this, "Los campos estan vacios, por favor rellenelos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnConsultar.setOnClickListener {
            binding.datosConsulta.text = ""
            val db : SQLiteDatabase = alarmasBdHelper.readableDatabase
            val cursor =  db.rawQuery(
                "SELECT * FROM alarma",
                null)

            if (cursor.moveToFirst()){
                do {
                    binding.datosConsulta.append(cursor.getString(0).toString() + ": ")
                    binding.datosConsulta.append(cursor.getString(1).toString()+ ", Fecha: ")
                    binding.datosConsulta.append(cursor.getString(2).toString() + " , Medicamento: ")
                    binding.datosConsulta.append(cursor.getString(3).toString() + " Horas, ")
                    binding.datosConsulta.append(cursor.getString(4).toString()+ " Dias \n")
                    binding.datosConsulta.append(cursor.getString(5).toString()+ " Estado \n" )
                    //binding.datosConsulta.append(cursor.getString(6).toString()+ " Dosis \n")
                    //binding.datosConsulta.append(cursor.getString(7).toString()+ " Dosis \n")
                    // binding.datosConsulta.append(cursor.getString(8).toString()+ " Dosis\n")
                    //binding.datosConsulta.append(cursor.getString(9).toString()+ " Dosis\n")
                    //binding.datosConsulta.append(cursor.getString(10).toString()+ " Dosis\n")
                }while (cursor.moveToNext())
            }
        }

        btnEliminarregistro.setOnClickListener {
            alarmasBdHelper.eliminarDato(txtId2.text.toString().toInt())
        }

        btnActualiarregistro.setOnClickListener {
            alarmasBdHelper.actualizar(txtId2.text.toString().toInt(),txtMedicamentoActualizar2.text.toString())
        }


    }
}