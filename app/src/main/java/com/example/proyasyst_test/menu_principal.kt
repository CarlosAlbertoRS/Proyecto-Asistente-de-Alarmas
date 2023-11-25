package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AlertDialog

class menu_principal : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val btnAgregar = findViewById<ImageButton>(R.id.btnAgregar)
        val btnRegistro = findViewById<ImageButton>(R.id.btnRegistro)

        btnAgregar.setOnClickListener {
            startActivity(Intent(this, agregar::class.java))
        }

        btnRegistro.setOnClickListener {
            startActivity(Intent(this, MenuRegistro::class.java))
        }

        val btnLlamada = findViewById<ImageButton>(R.id.btnLlamada)

        btnLlamada.setOnClickListener {
            val alerta = AlertDialog.Builder(this)


            alerta.setMessage("Si sufres de algun percance médico y/o efecto secundario, le recomendamos" +
                    " solicitar apoyo médico")
                .setCancelable(false)
                .setPositiveButton("si") { dialog, which ->
                    dialog.cancel()
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas llamar al numero de emergencia?")
            titulo.show()
        }

        val btnExtra = findViewById<Button>(R.id.button2)
        btnExtra.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}