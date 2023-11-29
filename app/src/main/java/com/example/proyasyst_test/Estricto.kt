package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AlertDialog

class Estricto : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estricto)

        val btnAtras = findViewById<ImageButton>(R.id.btnAtras)

        btnAtras.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
        }

        val btnSwich = findViewById<Switch>(R.id.switchEstricto)

        btnSwich.setOnClickListener {
            val alerta = AlertDialog.Builder(this)


            alerta.setMessage("Este modo esta diseñado para brindar apoyo en un lapso especificado")
                .setCancelable(false)
                .setPositiveButton("si") { dialog, which ->
                    startActivity(Intent(this, agregar::class.java))
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas desactivar el modo estricto?")
            titulo.show()
        }
    }
}