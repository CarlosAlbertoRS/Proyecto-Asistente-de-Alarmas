package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MenuAlarmaEstricto : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_alarma_estricto)
        val btnCancelar = findViewById<ImageButton>(R.id.btnBack)

        btnCancelar.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }

        val btnBorrar = findViewById<ImageButton>(R.id.btnEliminar)

        btnBorrar.setOnClickListener {
            val alerta = AlertDialog.Builder(this)


            alerta.setMessage("Se eliminara de los registros y no podra acceder a ella nuevamente")
                .setCancelable(false)
                .setPositiveButton("Aceptar") { dialog, which ->
                    dialog.cancel()
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas elminar este recordatorio?")
            titulo.show()
        }

        val btnSwitch = findViewById<Switch>(R.id.switchMAE)
        var modoEstrictoActivado = true

        btnSwitch.setOnClickListener {
            val alerta = AlertDialog.Builder(this)


            alerta.setMessage("Este modo esta diseñado para brindar apoyo en un lapso especificado")
                .setCancelable(false)
                .setPositiveButton("si") { dialog, which ->
                    modoEstrictoActivado = false
                    startActivity(Intent(this, agregar::class.java))
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    finish();
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                    btnSwitch.isChecked = modoEstrictoActivado // Restablecer el estado del Switch
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas desactivar el modo estricto?")
            titulo.show()
        }
    }
}