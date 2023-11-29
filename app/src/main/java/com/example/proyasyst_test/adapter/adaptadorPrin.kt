package com.example.proyasyst_test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.R
import com.example.proyasyst_test.variablesPrin

class adaptadorPrin (private val superHeroeLista:List<variablesPrin>, private val onClickListener: (variablesPrin)->Unit): RecyclerView.Adapter<viewFolderPrin>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewFolderPrin {
        val layoutInflater= LayoutInflater.from(parent.context)
        return viewFolderPrin(layoutInflater.inflate(R.layout.activity_item_principal,parent,false))
    }

    override fun onBindViewHolder(holder: viewFolderPrin, position: Int) {
        val item = superHeroeLista[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = superHeroeLista.size

}