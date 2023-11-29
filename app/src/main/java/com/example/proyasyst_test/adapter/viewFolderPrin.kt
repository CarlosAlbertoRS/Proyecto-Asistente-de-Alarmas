package com.example.proyasyst_test.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.databinding.ActivityItemPrincipalBinding
import com.example.proyasyst_test.variablesPrin

class viewFolderPrin (view: View) : RecyclerView.ViewHolder(view) {

    val binding = ActivityItemPrincipalBinding.bind(view)

    @SuppressLint("CheckResult")
    fun render(superHeroeModelo: variablesPrin, onClickListener: (variablesPrin)->Unit) {
        binding.medicamento.text = superHeroeModelo.medicamento
        binding.administrada.text = superHeroeModelo.administrada
        binding.total.text = superHeroeModelo.total
        binding.estado.text = superHeroeModelo.estado
        itemView.setOnClickListener{ onClickListener(superHeroeModelo)}
    }
}