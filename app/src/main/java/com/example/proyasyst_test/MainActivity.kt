package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bt1 = this.findViewById<Button>(R.id.btn_test)
        var btnBaseDatos = this.findViewById<Button>(R.id.btnBaseDatos)

        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Integracion de firebase completa ")
        analytics.logEvent("InitiScreen",bundle)

        bt1.setOnClickListener {
            var intent = Intent(this, testeo::class.java)
            startActivity(intent)
        }

        btnBaseDatos.setOnClickListener {
            var intent = Intent(this, testeobasededatos::class.java)
            startActivity(intent)
        }

    }
}