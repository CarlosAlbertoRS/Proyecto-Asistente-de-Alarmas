package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Estricto : AppCompatActivity() {
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
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estricto)

        val btnAtras = findViewById<ImageButton>(R.id.btnAtras)


        btnAtras.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
        }

        val alarmasBdHelper = miSQLiteHelper(this)
        val btnSwich = findViewById<Switch>(R.id.switchEstricto)
        var modoEstrictoActivado = true
        val txtMedicamento = findViewById<TextView>(R.id.txtMedic)
        val txtPeriodoDosis = findViewById<TextView>(R.id.txtIntervaloEstricto)
        val txtPeriodoTratamiento = findViewById<TextView>(R.id.txtPeriodoTratamientoEstricto)
        val btnAñadir = findViewById<ImageButton>(R.id.btnAñadir)
        val fecha = findViewById<TextView>(R.id.fechaEstaticaEstricto)
        val calendar = Calendar.getInstance()
        val fechaActual = calendar.time
        val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaFormateada = formatoFecha.format(fechaActual)

        fecha.text = fechaFormateada
        fecha.text = fecha.text.toString()

        btnSwich.setOnClickListener {
            val alerta = AlertDialog.Builder(this)


            alerta.setMessage("Este modo esta diseñado para brindar apoyo en un lapso especificado")
                .setCancelable(false)
                .setPositiveButton("si") { dialog, which ->
                    modoEstrictoActivado = false
                    startActivity(Intent(this, agregar::class.java))
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    finish();
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                    btnSwich.isChecked = modoEstrictoActivado // Restablecer el estado del Switch
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas desactivar el modo estricto?")
            titulo.show()
        }

        btnAñadir.setOnClickListener{
            var i = 0
            if (txtMedicamento.text.isNotBlank() &&
                txtPeriodoDosis.text.isNotBlank() &&
                txtPeriodoTratamiento.text.isNotBlank()
                && txtPeriodoDosis.text.toString().toInt() > 0
                && txtPeriodoTratamiento.text.toString().toInt() > 0) {
                val n = txtPeriodoDosis.text.toString().toInt()

                d1 = 1
                while (i <= 23) {
                    when (i) {
                        1 -> {d2 = 1}
                        2 -> {d3 = 1}
                        3 -> {d4 = 1}
                        4 -> {d5 = 1}
                        5 -> {d6 = 1}
                        6 -> {d7 = 1}
                        7 -> {d8 = 1}
                        8 -> {d9 = 1}
                        9 -> {d10 = 1}
                        10 -> {d11 = 1}
                        11 -> {d12 = 1}
                        12 -> {d13 = 1}
                        13 -> {d14 = 1}
                        14 -> {d15 = 1}
                        15 -> {d16 = 1}
                        16 -> {d17 = 1}
                        17 -> {d18 = 1}
                        18 -> {d19 = 1}
                        19 -> {d20 = 1}
                        20 -> {d21 = 1}
                        21 -> {d22 = 1}
                        22 -> {d23 = 1}
                        23 -> {d24 = 1}
                    }

                    i += n

                }
                alarmasBdHelper.anadirDato2(
                    fecha.text.toString(),
                    txtMedicamento.text.toString(),
                    txtPeriodoDosis.text.toString().toInt(),
                    txtPeriodoTratamiento.text.toString().toInt(),
                    1,
                    1,
                    d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11,d12, d13, d14, d15, d16,d17, d18, d19, d20, d21,
                    d22, d23, d24)
            }else{
                Toast.makeText(this,"Los campos estan vacion, favor de rellenarlos",Toast.LENGTH_LONG).show()
            }
        }
    }
}