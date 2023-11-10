package com.example.proyasyst_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch

class testeo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testeo)

        var bt1 = findViewById<Button>(R.id.button)
        var sw1 = findViewById<Switch>(R.id.sw_estado)

        bt1.setOnClickListener {
            sw1.isEnabled = true;
        }

    }
}