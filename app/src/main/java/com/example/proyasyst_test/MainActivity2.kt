package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var bt1 = this.findViewById<Button>(R.id.btn_test)
        var bt2 = this.findViewById<Button>(R.id.btn2)

        bt1.setOnClickListener {
            startActivity(Intent(this, testeo::class.java))
        }

        bt2.setOnClickListener {
            startActivity(Intent(this, basededatos::class.java))
        }

    }
}