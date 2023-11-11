package com.example.proyasyst_test

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database


class testeobasededatos : AppCompatActivity() {
    private lateinit var mDatabase: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testeobasededatos)

        var mtextviewdata = this.findViewById<TextView>(R.id.datoSacado)
        //val database = Firebase.database
       // val myRef = database.getReference("message")

       // myRef.setValue("Hello, World!")


        mDatabase = FirebaseDatabase.getInstance().reference

        mDatabase!!.child("Personas").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //Verificar si hay datos en el DataSnapshot
                if (dataSnapshot.exists()) {
                     //Obtener el valor del nodo "nombre" del DataSnapshot
                    val nombre = dataSnapshot.child("nombre").getValue()?.toString()
                    mtextviewdata.text = nombre
                    
                }else{
                    Toast.makeText(this@testeobasededatos, "El campo está vacío", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })



    }
}