package com.example.proyasyst_test

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.adapter.MedicamentoAdapter
import com.example.proyasyst_test.databinding.ActivityMenuRegistroBinding

class MenuRegistro : AppCompatActivity() {

    private lateinit var binding: ActivityMenuRegistroBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MedicamentoAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseHelper = DatabaseHelper(this)
        initRecyclerView()

        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            startActivity(Intent(this, menu_principal::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            finish()
        }

        // Llama a actualizarVista() cuando sea apropiado, por ejemplo, después de agregar o actualizar datos
        actualizarVista()
    }

    private fun initRecyclerView() {
        recyclerView = binding.recyclerRegistros
        recyclerView.layoutManager = LinearLayoutManager(this)
        val medicamentos = databaseHelper.obtenerMedicamentos()
        adapter = MedicamentoAdapter(medicamentos)
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    // Función para actualizar la vista después de cambiar los datos en la base de datos
    private fun actualizarVista() {
        // Realiza las operaciones de cambio de datos en la base de datos
        // Por ejemplo:
        // databaseHelper.anadirDato("10/11/2023", "Nuevo Medicamento", 8, 30, 1, 0, 0, 0, 0, 0)

        // Después de cambiar los datos, obtén los nuevos datos y notifica al adaptador
        val nuevosMedicamentos = databaseHelper.obtenerMedicamentos()
        adapter.actualizarDatos(nuevosMedicamentos)
    }
}
