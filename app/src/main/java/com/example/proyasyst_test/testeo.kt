package com.example.proyasyst_test

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.proyasyst_test.Helpers.SaveState
import com.example.proyasyst_test.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.DateFormat
import java.util.Calendar
import kotlin.time.Duration.Companion.hours

class testeo : AppCompatActivity() {

    private lateinit var picker: MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    private lateinit var saveState: SaveState
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission())
    { isGranted ->
        if(isGranted){
            call()
        } else{
            Toast.makeText(this,"Necesitas dar permisos para realizar esta accion.",Toast.LENGTH_SHORT).show()
        }
    }


    private fun call() {
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:9112")))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testeo)

        var bt1 = findViewById<Button>(R.id.button)
        var bt2 = findViewById<Button>(R.id.Cancelar)
        var bt3 = findViewById<Button>(R.id.Seleccionar)
        var usuario = findViewById<TextView>(R.id.nombre)
        var emer = findViewById<Button>(R.id.btnEmergencia)
        var sw1 = findViewById<Switch>(R.id.sw_estado)

        saveState = SaveState(this, "0B")
        usuario.text = saveState.getNombre()

        createNotificationChannel()
        bt1.setOnClickListener {
            setAlarm()
        }
        bt2.setOnClickListener {
            cancelAlarm()
        }
        bt3.setOnClickListener {
            setPicker()
        }
        emer.setOnClickListener {
            val intento = Intent(Intent.ACTION_CALL)
            intento.setData(Uri.parse("tel:9112"))
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                when{
                    ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED ->{
                        call()
                    }
                    else -> requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
                }
            }
            startActivity(intento)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
    }

    private fun setPicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Selecto Besto Meme")
            .build()

        picker.show(supportFragmentManager,"Asys-T")

        picker.addOnPositiveButtonClickListener {
            if(picker.hour > 12){
                String.format("%02d",picker.hour - 12) + " : " + String.format(
                    "%02d", picker.minute
                ) + "PM"
            } else{
                String.format("%02d",picker.hour) + " : " + String.format(
                    "%02d", picker.minute
                ) + "AM"
            }

            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0

            //==================================================================================
            // Para la opcion BASICA:
            //==================================================================================
            // Inicio: 8 am -> 10 pm
            //==================================================================================
            // Cada hora busca alarma |              Dosis                ||    Separacion
            //==================================================================================
            // Si cantidad = 1  => 12 pm                                  => 1 cada 24 hr
            // Si cantidad = 2  => 10 am | 10 pm                          => 1 cada 12 hr
            // Si cantidad = 3  =>  8 am |  3 pm | 9 pm                   => 1 cada  8 hr (+/-)
            // Si cantidad = 4  =>  8 am | 12 am | 4 pm |  8 pm           => 1 cada  4 hr
            // Si cantidad = 5  =>  8 am | 11 pm | 2 pm |  5 pm | 8 pm |  => 1 cada  3 hr (+/-)
            //==================================================================================

            //==================================================================================
            // Para la opcion Estricta:
            //==================================================================================
            // Inicio: 0 - 24 hrs
            //==================================================================================
            // Cada hora busca alarma ||             Dosis                ||    Separacion
            //==================================================================================
            // Si cantidad = c=(24/n) => d=(Int)(24/n) pm                 =>   1 cada n hr
            //==================================================================================

        }
    }

    private fun cancelAlarm() {
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,alarmaRecive::class.java)

        pendingIntent = PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_IMMUTABLE)
        alarmManager.cancel(pendingIntent)

        Toast.makeText(this,"Cancelada",Toast.LENGTH_SHORT).show()
    }

    private fun setAlarm() {

        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this,alarmaRecive::class.java)

        val receiver = ComponentName(this, alarmaRecive::class.java)

        pendingIntent = PendingIntent.getBroadcast(this,0,
            intent, PendingIntent.FLAG_IMMUTABLE)

        if(saveState.getAlarm()==0){
            saveState.setAlarm(1)
            val calendario = Calendar.getInstance().time.hours
            val hora = findViewById<TextView>(R.id.hora)
            hora.text = (calendario + 1).toString()

            if(System.currentTimeMillis().toInt() !=0){}
            val calendar: Calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, calendario+1)
                set(Calendar.MINUTE, 0)
            }

            alarmManager?.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                1000 * 60 * 60,
                pendingIntent)


            this.packageManager.setComponentEnabledSetting(
                receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )

            Toast.makeText(this,"Creada",Toast.LENGTH_SHORT).show()

        } else{
            Toast.makeText(this,"Ya estuvo suavi-crema",Toast.LENGTH_SHORT).show()
        }

        // Crear alarma a partir de la hora del usuario (ej. Si activa a las 8:15 poner a las 9)

    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name : CharSequence = "canalRecordatorio"
            val description = "Channel for Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("Asys-T",name,importance)
            channel.description = description
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}