package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bt1 = this.findViewById<Button>(R.id.btn_test)
        var bt2 = this.findViewById<Button>(R.id.btn2)

        bt1.setOnClickListener {
            var intent = Intent(this, testeo::class.java)
            startActivity(intent)
        }

        bt2.setOnClickListener {
            var intent = Intent(this, basededatos::class.java)
            startActivity(intent)
        }

    }
}