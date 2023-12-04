package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyasyst_test.adapter.adaptadorPrin
import com.example.proyasyst_test.databinding.ActivityMenuPrincipalBinding


class menu_principal : AppCompatActivity() {

    private lateinit var binding: ActivityMenuPrincipalBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()

        val btnMas= findViewById<ImageButton>(R.id.btnMas)

        btnMas.setOnClickListener {
            startActivity(Intent(this, agregar::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
        }

        val btnRegistro = findViewById<ImageButton>(R.id.btnRegistro)
        btnRegistro.setOnClickListener {
            startActivity(Intent(this, MenuRegistro::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
        }

        val btnLlamada = findViewById<ImageButton>(R.id.btnLlamada)

        btnLlamada.setOnClickListener {
            val alerta = AlertDialog.Builder(this)


            alerta.setMessage("Si sufres de algun percance médico y/o efecto secundario, le recomendamos" +
                    " solicitar apoyo médico")
                .setCancelable(false)
                .setPositiveButton("si") { dialog, which ->
                    dialog.cancel()
                }
                .setNegativeButton("Cancelar") { dialog, which ->
                    dialog.cancel()
                }

            val titulo = alerta.create()
            titulo.setTitle("¿Deseas llamar al numero de emergencia?")
            titulo.show()
        }

        val btnExtra = findViewById<Button>(R.id.button2)
        btnExtra.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
        }

    }

    private fun initRecycleView() {
        binding.recyclerPrin.layoutManager = LinearLayoutManager(this)
        binding.recyclerPrin.adapter =
            adaptadorPrin(listaDatosPrin.ListaMedicamentos) { medicina ->
                onItemSeleccionado(medicina)
            }
    }

    fun onItemSeleccionado(medicina: variablesPrin) {
        Toast.makeText(this,medicina.medicamento,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,medicina.tiempos,Toast.LENGTH_SHORT).show()
    }
}