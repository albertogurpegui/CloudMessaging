package com.example.albertoguerpegui.cloudmessaging
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
//Esta clase solo se ejecutara si tienes una version android de 8 o mayor en el movil
//Si es 8 o mayor se creara un canal para la comunicacion entre firebase y la aplicacion
class NotificationUtils(base: Context): ContextWrapper(base) {
    companion object {
        const val CHANNEL_ID = "com.example.albertoguerpegui.cloudmessaging.CHANNEL_ID"
        const val CHANNEL_NAME = "Show notifications UTAD"
    }


    private val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    init {
        createChannels()
    }


    fun deleteNotificationChannel() {
        mNotificationManager.deleteNotificationChannel(CHANNEL_ID)
    }

    private fun createChannels() {
        NotificationChannel(CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT).apply {
            enableLights(true)
            enableVibration(true)
            importance = NotificationManager.IMPORTANCE_LOW
            lightColor = Color.GREEN
            lockscreenVisibility = Notification.VISIBILITY_PRIVATE

            mNotificationManager.createNotificationChannel(this)
        }
    }
}