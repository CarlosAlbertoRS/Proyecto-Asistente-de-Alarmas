package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bt1 = this.findViewById<Button>(R.id.btn_test)

        bt1.setOnClickListener {
            var intent = Intent(this, testeo::class.java)
            startActivity(intent)
        }

        val btnRed = this.findViewById<Button>(R.id.btnRed)

        btnRed.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
        }

        val btnEstricto = this.findViewById<Button>(R.id.btnEstricto)

        btnEstricto.setOnClickListener {
            startActivity(Intent(this, Estricto::class.java))
        }

        val btnAlarma = this.findViewById<Button>(R.id.btnAlarma)

        btnAlarma.setOnClickListener {
            startActivity(Intent(this, MenuAlarma::class.java))
        }

        val btnAlar = this.findViewById<Button>(R.id.btnAlar)

        btnAlar.setOnClickListener {
            startActivity(Intent(this, Alarma::class.java))
        }

        val btnLogo = this.findViewById<Button>(R.id.btnLogo)

        btnLogo.setOnClickListener {
            startActivity(Intent(this, logo::class.java))
        }
    }
}