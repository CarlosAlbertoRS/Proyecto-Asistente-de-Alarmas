package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.proyasyst_test.Helpers.SaveState
import com.example.proyasyst_test.tutorial.tutorial_1

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var saveState:SaveState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val iv_bg = findViewById<ImageView>(R.id.iv_bg)
        val iv_bg2 = findViewById<ImageView>(R.id.iv_bg2)
        val iv_bg3 = findViewById<ImageView>(R.id.iv_bg3)

        iv_bg.alpha = 0f
        iv_bg2.alpha = 0f
        iv_bg3.alpha = 0f

        iv_bg2.animate().setDuration(1500).alpha(1f).withEndAction{ finish() }
        iv_bg3.animate().setDuration(1500).alpha(1f).withEndAction{ finish() }
        iv_bg.animate().setDuration(1500).alpha(1f).withEndAction{

            saveState = SaveState(this, "0B")
            if(saveState.getState()==1){
                val i = Intent(this, testeo::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            } else{
            val i = Intent(this, tutorial_1::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
            }
        }
    }
}