package com.example.startnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startNotification()
    }

    private fun startNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importan = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANEL", "name", importan)
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
        sendNotification()
    }

    private fun sendNotification(){
        val builder = NotificationCompat.Builder(this, "CHANEL")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("TITLE")
            .setContentText("TEXT ABOUT")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(100, builder.build())
        }
    }
}