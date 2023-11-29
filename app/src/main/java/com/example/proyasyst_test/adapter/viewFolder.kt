package com.example.proyasyst_test.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.databinding.ItemRegistroActivasBinding
import com.example.proyasyst_test.variables

class viewFolder (view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemRegistroActivasBinding.bind(view)

    @SuppressLint("CheckResult")
    fun render(DatosMedicamentos: variables, onClickListener: (variables)->Unit) {
        binding.medicamento.text = DatosMedicamentos.medicamento
        binding.fecha.text = DatosMedicamentos.fecha
        binding.administrada.text = DatosMedicamentos.administrada
        binding.total.text = DatosMedicamentos.total
        binding.estado.text = DatosMedicamentos.estado
        binding.tipo.text = DatosMedicamentos.tipo
        itemView.setOnClickListener{ onClickListener(DatosMedicamentos)}
    }
}