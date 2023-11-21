package com.example.proyasyst_test

import android.Manifest
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.annotation.ColorInt
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.proyasyst_test.Helpers.SaveState

class alarmaRecive: BroadcastReceiver() {
    private lateinit var saveState: SaveState
    override fun onReceive(context: Context?, intent: Intent?) {

        saveState = SaveState(context!!, "0B")

        val i = Intent(context, DestinationActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivities(context,0, arrayOf(i),
            PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(context!!,"Asys-T")
            .setSmallIcon(R.drawable.olla)
            .setContentTitle("Alarma Activa !")
            .setContentText("Hola "+saveState.getNombre()+"., ya es hora de que se tome su medicación.")
            .setAutoCancel(true)
            .setStyle(NotificationCompat.BigTextStyle().bigText("" +
                              "\nSe activo una alarma que indica que debes tomarte tus pastillas." +
                            "\n\nTe invitamos a dar click aquí para desactivarla." +
                            "\n\n_________________________" +
                              "\n>> AsysT - Team    (°<°) / "))
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setLights(1,500,500)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notificationManager.notify(saveState.getAlarm(),builder.build())
        saveState.setAlarm(saveState.getAlarm()+1)
    }

}