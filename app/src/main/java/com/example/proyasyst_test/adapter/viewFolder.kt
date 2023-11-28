package com.example.proyasyst_test.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.databinding.ItemRegistroActivasBinding
import com.example.proyasyst_test.variables

class viewFolder (view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemRegistroActivasBinding.bind(view)

    @SuppressLint("CheckResult")
    fun render(superHeroeModelo: variables, onClickListener: (variables)->Unit) {
        binding.medicamento.text = superHeroeModelo.medicamento
        binding.fecha.text = superHeroeModelo.fecha
        binding.administrada.text = superHeroeModelo.administrada
        binding.total.text = superHeroeModelo.total
        binding.estado.text = superHeroeModelo.estado
        binding.tipo.text = superHeroeModelo.tipo
        itemView.setOnClickListener{ onClickListener(superHeroeModelo)}
    }
}