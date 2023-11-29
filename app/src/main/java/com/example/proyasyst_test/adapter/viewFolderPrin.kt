package com.example.proyasyst_test.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.databinding.ActivityItemPrincipalBinding
import com.example.proyasyst_test.variablesPrin

class viewFolderPrin (view: View) : RecyclerView.ViewHolder(view) {

    val binding = ActivityItemPrincipalBinding.bind(view)

    @SuppressLint("CheckResult")
    fun render(DatosMedicamentos: variablesPrin, onClickListener: (variablesPrin)->Unit) {
        binding.medicamento.text = DatosMedicamentos.medicamento
        binding.tiempos.text = DatosMedicamentos.tiempos
        binding.consumidas.text = DatosMedicamentos.consumidas
        binding.totales.text = DatosMedicamentos.totales
        itemView.setOnClickListener{ onClickListener(DatosMedicamentos)}
    }
}