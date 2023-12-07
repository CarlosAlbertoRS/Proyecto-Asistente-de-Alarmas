package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "medicamentos.db"
        const val DATABASE_VERSION = 1

        const val TABLE_MEDICAMENTOS = "medicamentos"
        const val COLUMN_ID = "id"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_FRECUENCIA = "frecuencia"
        const val COLUMN_PERIODO_TOTAL = "periodo_total"
        const val COLUMN_ESTADO = "estado"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_MEDICAMENTOS ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_FECHA TEXT, $COLUMN_NOMBRE TEXT, $COLUMN_FRECUENCIA TEXT, $COLUMN_PERIODO_TOTAL TEXT, $COLUMN_ESTADO TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Puedes implementar la lógica de actualización aquí si es necesario
    }

    fun anadirDato( fecha: String, medicamento: String, periodoHora: Int, periodoTratamiento: Int, estado: Int
                    ) {
        val datos = ContentValues()
        datos.put("fecha", fecha)
        datos.put("nombre", medicamento)
        datos.put("frecuencia", periodoHora)
        datos.put("periodo_total", periodoTratamiento)
        datos.put("estado", estado)


        val db = this.writableDatabase
        val nuevoReg = db?.insert("medicamentos",null, datos)

        db.close()
    }

    @SuppressLint("Range")
    fun obtenerMedicamentos(): List<variables> {
        val medicamentos = mutableListOf<variables>()

        // Accede a la base de datos para obtener los medicamentos
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_MEDICAMENTOS", null)

        if (cursor.moveToFirst()) {
            do {
                // Asegúrate de ajustar los nombres de las columnas según tu esquema de base de datos
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val frecuencia = cursor.getString(cursor.getColumnIndex(COLUMN_FRECUENCIA))
                val periodoTotal = cursor.getString(cursor.getColumnIndex(COLUMN_PERIODO_TOTAL))
                val estado = cursor.getString(cursor.getColumnIndex(COLUMN_ESTADO))

                // Crea un objeto Medicamento y agrégalo a la lista
                val medicamento = variables("05/12/2023", nombre, frecuencia, periodoTotal, estado)
                medicamentos.add(medicamento)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return medicamentos
    }

}
