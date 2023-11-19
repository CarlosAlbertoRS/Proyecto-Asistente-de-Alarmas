package com.example.proyasyst_test.tutorial

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.proyasyst_test.Helpers.SaveState
import com.example.proyasyst_test.R
import com.example.proyasyst_test.testeo


class Tutorial_4 : AppCompatActivity() {

    private lateinit var nextCard4: CardView
    private lateinit var nextCard44: CardView
    private lateinit var saveState:SaveState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial4)

        nextCard4 = findViewById(R.id.nextCardtutorial4)
        nextCard44 = findViewById(R.id.nextCard44)
        val nom = findViewById<EditText>(R.id.nom)


        nextCard4.setOnClickListener {
            if(nom.text.toString()=="" || nom.text.toString().isEmpty()){
                val miDialogo = AlertDialog.Builder(this)
                miDialogo.setTitle("Atencion")
                miDialogo.setMessage("Es necesario que coloques tu nombre en el recuadro que esta en el centro centro antes de comenzar.")
                miDialogo.setPositiveButton("Ok", null)
                val dialog = miDialogo.create()
                dialog.show()
            }
            else{
                saveState = SaveState(this, "0B")
                saveState.setState(1,nom.text.toString())

                var intent = Intent(this, testeo::class.java)
                startActivity(intent)
                finish()
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
            }
        }

        nextCard44.setOnClickListener {
            var intent = Intent(this, Tutorial_3::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.right_in,R.anim.right_out)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.right_in,R.anim.right_out)
    }
}