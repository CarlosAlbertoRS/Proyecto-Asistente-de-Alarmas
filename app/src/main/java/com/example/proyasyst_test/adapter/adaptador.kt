package com.example.proyasyst_test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.R
import com.example.proyasyst_test.variables

class adaptador(private val MedicinaLista: List<variables>, private val onClickListener: (variables)->Unit): RecyclerView.Adapter<viewFolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewFolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return viewFolder(layoutInflater.inflate(R.layout.item_registro_activas,parent,false))
    }

    override fun onBindViewHolder(holder: viewFolder, position: Int) {
        val item = MedicinaLista[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = MedicinaLista.size

}