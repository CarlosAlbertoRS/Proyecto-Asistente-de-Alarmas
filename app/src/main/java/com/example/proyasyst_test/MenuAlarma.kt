package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MenuAlarma : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_alarma)

        val btnCancelar = findViewById<ImageButton>(R.id.btnCancelar)

        btnCancelar.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
        }
    }
}