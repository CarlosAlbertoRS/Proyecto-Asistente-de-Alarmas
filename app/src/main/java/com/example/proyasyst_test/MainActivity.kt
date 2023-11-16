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

    }
}