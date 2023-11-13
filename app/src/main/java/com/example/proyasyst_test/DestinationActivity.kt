package com.example.proyasyst_test

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Vibrator
import android.transition.Explode
import android.view.WindowManager
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class DestinationActivity : AppCompatActivity() {
    private lateinit var mp: MediaPlayer
    private lateinit var v: Vibrator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_destination)

        mp = MediaPlayer.create(this, R.raw.alarma)
        mp.start ()
        mp.isLooping = true

        v = getSystemService(VIBRATOR_SERVICE) as Vibrator
        val pattern = longArrayOf(0, 225, 800)
        v.vibrate(pattern, 0)

        val btAceptar = findViewById<ImageButton>(R.id.imBA)
        btAceptar.setOnClickListener{

            mp.stop ()
            v.cancel()

            var intent = Intent(this, testeo::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
            this.finish()

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        mp.stop ()
        v.cancel()
        this.finish()
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }
}