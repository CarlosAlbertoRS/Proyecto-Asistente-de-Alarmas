package com.example.proyasyst_test

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "alarmasasyst.db", null, 3) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE alarma " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha String, medicamento String, periodoHora INTEGER, periodoTratamiento INTEGER, " +
                "estado INTEGER, d1 INTEGER, d2 INTEGER, d3 INTEGER, d4 INTEGER, d5 INTEGER)"

        val ordenCreacion2 = "CREATE TABLE alarmaEstricto " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha String, medicamento String, periodoHora INTEGER, periodoTratamiento INTEGER, " +
                "estado INTEGER, d1 INTEGER, d2 INTEGER, d3 INTEGER, d4 INTEGER, d5 INTEGER" +
                ", d6 INTEGER, d7 INTEGER, d8 INTEGER, d9 INTEGER, d10 INTEGER" +
                ", d11 INTEGER, d12 INTEGER, d13 INTEGER, d14 INTEGER, d15 INTEGER" +
                ", d16 INTEGER, d17 INTEGER, d18 INTEGER, d19 INTEGER, d20 INTEGER" +
                ", d21 INTEGER, d22 INTEGER, d23 INTEGER, d24 INTEGERº)"

        db!!.execSQL(ordenCreacion)
        db!!.execSQL(ordenCreacion2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS alarma"
        val ordenBorrado2 = "DROP TABLE IF EXISTS alarmaEstricto"

        db!!.execSQL(ordenBorrado)
        db!!.execSQL(ordenBorrado2)
        onCreate(db)
    }


    fun anadirDato( fecha: String, medicamento: String, periodoHora: Int, periodoTratamiento: Int, estado: Int, d1: Int
                    , d2: Int, d3: Int, d4: Int, d5: Int) {
        val datos = ContentValues()
        datos.put("fecha",fecha)
        datos.put("medicamento",medicamento)
        datos.put("periodoHora", periodoHora)
        datos.put("periodoTratamiento", periodoTratamiento)
        datos.put("estado", estado)
        datos.put("d1",d1)
        datos.put("d2",d2)
        datos.put("d3",d3)
        datos.put("d4",d4)
        datos.put("d5",d5)

        val db = this.writableDatabase
        db.insert("alarma",null, datos)
        db.close()
    }

    fun anadirDato2( fecha: String, medicamento: String, periodoHora: Int, periodoTratamiento: Int, estado: Int, d1: Int
                     , d2: Int, d3: Int, d4: Int, d5: Int, d6: Int, d7: Int, d8: Int, d9: Int, d10: Int, d11: Int
                     , d12: Int, d13: Int, d14: Int, d15: Int, d16: Int, d17: Int, d18: Int, d19: Int, d20: Int, d21: Int
                     , d22: Int, d23: Int, d24: Int) {
        val datos2 = ContentValues()
        datos2.put("fecha",fecha)
        datos2.put("medicamento",medicamento)
        datos2.put("periodoHora", periodoHora)
        datos2.put("periodoTratamiento", periodoTratamiento)
        datos2.put("estado", estado)
        datos2.put("d1",d1)
        datos2.put("d2",d2)
        datos2.put("d3",d3)
        datos2.put("d4",d4)
        datos2.put("d5",d5)
        datos2.put("d6",d6)
        datos2.put("d7",d7)
        datos2.put("d8",d8)
        datos2.put("d9",d9)
        datos2.put("d10",d10)
        datos2.put("d11",d11)
        datos2.put("d12",d12)
        datos2.put("d13",d13)
        datos2.put("d14",d14)
        datos2.put("d15",d15)
        datos2.put("d16",d16)
        datos2.put("d17",d17)
        datos2.put("d18",d18)
        datos2.put("d19",d19)
        datos2.put("d20",d20)
        datos2.put("d21",d21)
        datos2.put("d22",d22)
        datos2.put("d23",d23)
        datos2.put("d24",d24)

        val db = this.writableDatabase
        db.insert("alarmaEstricto",null, datos2)
        db.close()
    }

    fun actDatos(id: Int, Estado: Int, d1: Int, d2: Int, d3: Int, d4: Int, d5: Int){

    }

    fun actualizar(id: Int, medicamento: String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("medicamento", medicamento)
        // Actualizar el registro
        db.update("alarma", values, "id = ?", arrayOf(java.lang.String.valueOf(id)))
        db.close()
    }

    fun eliminarDato(id: Int){
        val db = this.writableDatabase
        db.delete("alarma", "id = ?", arrayOf(id.toString()))
        db.close()
    }

    fun actDatos2(id: Int, Estado: Int, d1: Int, d2: Int, d3: Int, d4: Int, d5: Int, d6: Int
                  , d7: Int, d8: Int, d9: Int, d10: Int, d11: Int, d12: Int
                  , d13: Int, d14: Int, d15: Int, d16: Int, d17: Int, d18: Int
                  , d19: Int, d20: Int, d21: Int, d22: Int, d23: Int, d24: Int)
    {

    }

}