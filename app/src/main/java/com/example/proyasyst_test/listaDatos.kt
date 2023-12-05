package com.example.proyasyst_test

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class listaDatos(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    @SuppressLint("Range")
    fun obtenerMedicamentos(): List<variables> {
        val listaMedicamentos = mutableListOf<variables>()
        val db = dbHelper.readableDatabase

        val columns = arrayOf(
            DatabaseHelper.COLUMN_FECHA,
            DatabaseHelper.COLUMN_NOMBRE,
            DatabaseHelper.COLUMN_FRECUENCIA,
            DatabaseHelper.COLUMN_PERIODO_TOTAL,
            DatabaseHelper.COLUMN_ESTADO
        )

        val cursor: Cursor = db.query(
            DatabaseHelper.TABLE_MEDICAMENTOS,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        while (cursor.moveToNext()) {
            val fecha = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FECHA))
            val nombre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE))
            val frecuencia = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_FRECUENCIA))
            val periodoTotal = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PERIODO_TOTAL))
            val estado = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ESTADO))

            val medicamento = variables(fecha, nombre, frecuencia, periodoTotal, estado)
            listaMedicamentos.add(medicamento)
        }

        cursor.close()
        db.close()

        return listaMedicamentos
    }

    fun agregarMedicamento(medicamento: variables) {
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put(DatabaseHelper.COLUMN_FECHA, medicamento.fecha)
        values.put(DatabaseHelper.COLUMN_NOMBRE, medicamento.nombre)
        values.put(DatabaseHelper.COLUMN_FRECUENCIA, medicamento.frecuencia)
        values.put(DatabaseHelper.COLUMN_PERIODO_TOTAL, medicamento.periodoTotal)
        values.put(DatabaseHelper.COLUMN_ESTADO, medicamento.estado)

        db.insert(DatabaseHelper.TABLE_MEDICAMENTOS, null, values)
        db.close()
    }
}
