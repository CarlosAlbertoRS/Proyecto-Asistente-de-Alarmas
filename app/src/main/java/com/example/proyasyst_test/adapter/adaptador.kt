package com.example.proyasyst_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.proyasyst_test.R
import com.example.proyasyst_test.variables

class adaptador
    : RecyclerView.Adapter<adaptador.ViewHolder>() {
        inner class ViewHolder: RecylerView.ViewHolder{

            val txtMedic: EditText
            val txtIntervalo: EditText
            val  txtTotal: EditText
            val txtEsado: EditText

            constructor(view: View) : supes(view){

            }


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}