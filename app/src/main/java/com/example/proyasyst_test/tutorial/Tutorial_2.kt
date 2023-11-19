package com.example.proyasyst_test.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.proyasyst_test.R

class Tutorial_2 : AppCompatActivity() {

    private lateinit var nextCard2: CardView
    private lateinit var nextCard22: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial2)

        nextCard2 = findViewById(R.id.nextCardtutorial2)
        nextCard22 = findViewById(R.id.nextCardtutorial22)

        nextCard2.setOnClickListener {
            var intent = Intent(this, Tutorial_3::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.left_in,R.anim.left_out)
        }

        nextCard22.setOnClickListener {
            var intent = Intent(this, tutorial_1::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_in,R.anim.right_out)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.right_in,R.anim.right_out)
    }
}