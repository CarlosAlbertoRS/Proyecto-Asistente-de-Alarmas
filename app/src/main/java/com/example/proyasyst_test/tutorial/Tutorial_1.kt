package com.example.proyasyst_test.tutorial

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.proyasyst_test.R

class tutorial_1 : AppCompatActivity() {

    private lateinit var nextCard: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial1)

        nextCard = findViewById(R.id.nextCardtutorial1)

        revisarPermisos()

        nextCard.setOnClickListener {
            var intent = Intent(this, Tutorial_2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.left_in,R.anim.left_out)
        }
    }

    private fun revisarPermisos() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            pedirPermisos()
        }
    }

    private fun pedirPermisos() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.POST_NOTIFICATIONS)){
            val miDialogo = AlertDialog.Builder(this)
            miDialogo.setTitle("Atencion")
            miDialogo.setMessage("Es necesario que aceptes los permisos de notificaciones y llamadas de emergencia antes de continuar. Por favor, verifica tenerlos activos en: Ajustes -> Informacíon de la app -> Permisos (Acepta todos)")
            miDialogo.setPositiveButton("Ok", null)
            val dialog = miDialogo.create()
            dialog.show()
        }else{
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS, Manifest.permission.CALL_PHONE),222)
        }
    }
}