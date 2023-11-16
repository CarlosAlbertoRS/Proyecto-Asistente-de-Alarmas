package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MenuRegistro : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_registro)

        val btnVolver= findViewById<ImageButton>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
        }
    }
}