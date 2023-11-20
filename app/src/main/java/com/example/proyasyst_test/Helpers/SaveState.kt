package com.example.proyasyst_test.Helpers

import android.content.Context
import android.content.SharedPreferences


public class SaveState(context: Context, saveName: String) {

    private var sp: SharedPreferences? = context.getSharedPreferences(saveName, Context.MODE_PRIVATE)

    fun setState(key: Int,usuario: String) {
        val editor = sp!!.edit()
        editor.putInt("Key", key)
        editor.putString("usuNom",usuario)
        editor.apply()
    }

    fun getState(): Int {
        return sp!!.getInt("Key", 0)
    }
    fun getNombre(): String? {
        return sp!!.getString("usuNom","0")
    }

    fun setAlarm(active: Int){
        val editor = sp!!.edit()
        editor.putInt("Alarm", active)
        editor.apply()
    }
    fun getAlarm(): Int {
        return sp!!.getInt("Alarm",0)
    }
}