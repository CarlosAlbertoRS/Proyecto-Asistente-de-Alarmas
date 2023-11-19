package com.example.proyasyst_test.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.proyasyst_test.R

class Tutorial_3 : AppCompatActivity() {

    private lateinit var nextCard3: CardView
    private lateinit var nextCard33: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial3)

        nextCard3 = findViewById(R.id.nextCardtutorial3)
        nextCard33 = findViewById(R.id.nextCard33)

        nextCard3.setOnClickListener {
            var intent = Intent(this, Tutorial_4::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.left_in,R.anim.left_out)
        }

        nextCard33.setOnClickListener {
            var intent = Intent(this, Tutorial_2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_in,R.anim.right_out)
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.right_in,R.anim.right_out)
    }
}