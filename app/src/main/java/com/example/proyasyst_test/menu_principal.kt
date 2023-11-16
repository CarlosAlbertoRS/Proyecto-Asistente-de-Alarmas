package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class menu_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val btnAgregar = findViewById<ImageButton>(R.id.btnAgregar)
        val btnRegistro = findViewById<ImageButton>(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            startActivity(Intent(this, agregar::class.java))
        }

        btnRegistro.setOnClickListener {
            startActivity(Intent(this, MenuRegistro::class.java))
        }

    }
}