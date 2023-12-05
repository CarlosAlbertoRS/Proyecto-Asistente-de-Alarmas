package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyasyst_test.adapter.adaptador
import com.example.proyasyst_test.databinding.ActivityMenuRegistroBinding

import android.database.sqlite.SQLiteDatabase

class MenuRegistro : AppCompatActivity() {

    private lateinit var binding: ActivityMenuRegistroBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()

        val alarmasBdHelper = miSQLiteHelper(this)
        val btnVolver= findViewById<ImageButton>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish();
        }

        /*val switch= findViewById<Switch>(R.id.switch2)
        var modoEstrictoActivado = false
        switch.setOnClickListener {isChecked ->
            if (isChecked.isActivated) {
                switch.text = "Alarmas activas"
                modoEstrictoActivado = true
            } else {
                switch.text = "Alarmas finalizadas"
                switch.isChecked = modoEstrictoActivado
            }
        }*/

    }

    private fun initRecycleView() {
        binding.recyclerRegistros.layoutManager = LinearLayoutManager(this)
        binding.recyclerRegistros.adapter =
            adaptador(listaDatos.ListaMedicamentos) { medicina ->
                onItemSeleccionado(medicina)
            }
    }

    fun onItemSeleccionado(medicina: variables) {
        Toast.makeText(this,medicina.medicamento,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,medicina.estado,Toast.LENGTH_SHORT).show()
    }

}
