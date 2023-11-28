package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyasyst_test.databinding.ActivityMainBinding

class MenuRegistro : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_registro)

        val btnVolver= findViewById<ImageButton>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()
    }

    private fun initRecycleView() {

        binding.recyclerSuperHeroe.layoutManager = LinearLayoutManager(this)
        binding.recyclerSuperHeroe.adapter =
            SuerHeroeAdaptador(listaDatos.ListaSuperHeroes) { superHeroe ->
                onItemSeleccionado(superHeroe)
            }
    }

    fun onItemSeleccionado(superHeroe: variables) {
        Toast.makeText(this,superHeroe.medicamento,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,superHeroe.estado,Toast.LENGTH_SHORT).show()
    }
}