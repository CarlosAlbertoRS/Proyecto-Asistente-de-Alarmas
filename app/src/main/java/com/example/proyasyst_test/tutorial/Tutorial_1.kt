package com.example.proyasyst_test.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.proyasyst_test.R

class tutorial_1 : AppCompatActivity() {

    private lateinit var nextCard: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial1)

        nextCard = findViewById(R.id.nextCardtutorial1)

        nextCard.setOnClickListener {
            var intent = Intent(this, Tutorial_2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.left_in,R.anim.left_out)
        }
    }
}