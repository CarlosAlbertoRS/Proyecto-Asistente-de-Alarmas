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
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
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
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                    btnSwich.isChecked = modoEstrictoActivado // Restablecer el estado del Switch
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas activar el modo estricto?")
            titulo.show()
        }


    }
}