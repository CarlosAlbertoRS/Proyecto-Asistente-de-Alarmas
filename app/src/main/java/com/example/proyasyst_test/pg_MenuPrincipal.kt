package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pg_MenuPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pg_menu_principal)

        var bt1 = this.findViewById<Button>(R.id.btn_test)

        bt1.setOnClickListener {
            var intent = Intent(this, testeo::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }

    }
}