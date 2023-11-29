package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.adapter.adaptador
import com.example.proyasyst_test.databinding.ActivityMenuRegistroBinding

class MenuRegistro : AppCompatActivity() {

    private lateinit var binding: ActivityMenuRegistroBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_registro)

        val btnVolver= findViewById<ImageButton>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
        }

        binding = ActivityMenuRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()
    }

    private fun initRecycleView() {
        binding.recyclerRegistros.layoutManager = LinearLayoutManager(this)
        binding.recyclerRegistros.adapter =
            adaptador(listaDatos.ListaSuperHeroes) { superHeroe ->
                onItemSeleccionado(superHeroe)
            }
    }

    fun onItemSeleccionado(superHeroe: variables) {
        Toast.makeText(this,superHeroe.medicamento,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,superHeroe.estado,Toast.LENGTH_SHORT).show()
    }
}