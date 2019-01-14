package com.example.albertoguerpegui.cloudmessaging

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Te comprueba si la version de andorid es 8 o mayor
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationUtils(this)
        }
    }
}
