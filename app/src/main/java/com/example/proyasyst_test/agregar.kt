package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AlertDialog
import com.google.android.material.switchmaterial.SwitchMaterial

class agregar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        val btnCancelar = findViewById<ImageButton>(R.id.btnCancelar)

        btnCancelar.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
        }

        val btnSwich = findViewById<Switch>(R.id.switchAgregar)

        btnSwich.setOnClickListener {
            val alerta = AlertDialog.Builder(this)


            alerta.setMessage("Este modo esta diseñado para brindar apoyo las 24hr. a partir del lapso especificado")
                .setCancelable(false)
                .setPositiveButton("si") { dialog, which ->
                    startActivity(Intent(this, Estricto::class.java))
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                    btnSwich.isChecked
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas activar el modo estricto?")
            titulo.show()
        }

    }
}