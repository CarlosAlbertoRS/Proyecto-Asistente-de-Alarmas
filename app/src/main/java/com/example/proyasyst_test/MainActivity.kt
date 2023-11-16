package com.example.proyasyst_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import com.example.proyasyst_test.Adapters.OnBoardingAdapter2

class MainActivity : AppCompatActivity() {

    private lateinit var nextCard: CardView
    private lateinit var dotslayout: LinearLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextCard = findViewById(R.id.nextCard)
        dotslayout = findViewById(R.id.dotsL)
        viewPager = findViewById(R.id.slider)

        var adapter = OnBoardingAdapter2(this)

        Thread.sleep(5000)

        var intent = Intent(this, pg_MenuPrincipal::class.java)
        startActivity(intent)
        //viewPager.adapter = adapter

    }
}
