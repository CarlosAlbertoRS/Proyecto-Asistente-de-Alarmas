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
        val estado = 1
        val d1 = 1
        val d2 = 0
        val d3 = 0
        val d4 = 0
        val d5 = 0


        val alarmasBdHelper = miSQLiteHelper(this)
        val calendar = Calendar.getInstance()
        val fechaActual = calendar.time
        val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaFormateada = formatoFecha.format(fechaActual)
        val btnActualiarregistro = findViewById<Button>(R.id.btnActualiarregistro)
        fecha.text = fechaFormateada


        fecha.text = fecha.text.toString()
        binding.btnAgregarDatos.setOnClickListener {

            if (binding.txtMedicamento.text.isNotBlank() &&
                binding.txtPeriodoDeTiempo.text.isNotBlank() &&
                binding.txtPeriodoDeTratamiento.text.isNotBlank())
            {

                if (binding.switch1.isChecked == true){
                    alarmasBdHelper.anadirDato(
                        fecha.text.toString(),
                        txtMedicamento.text.toString(),
                        txtIntervaloMedicamento.text.toString().toInt(),
                        txteridoTratamiento.text.toString().toInt(),
                        estado = 1,
                        d1, d2, d3, d4, d5)
                }else
                {
                    alarmasBdHelper.anadirDato(
                        fecha.text.toString(),
                        txtMedicamento.text.toString(),
                        txtIntervaloMedicamento.text.toString().toInt(),
                        txteridoTratamiento.text.toString().toInt(),
                        estado = 0,
                        d1, d2, d3, d4, d5)
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
                    binding.datosConsulta.append(cursor.getString(1).toString()+ ", ")
                    binding.datosConsulta.append(cursor.getString(2).toString() + " , ")
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