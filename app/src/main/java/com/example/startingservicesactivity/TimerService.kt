package com.example.startingservicesactivity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TimerService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val countValue = intent?.getIntExtra("countValue", 0) ?: 0

        runTimer(countValue)

        return super.onStartCommand(intent, flags, startId)
    }

    private fun runTimer(countValue: Int) {
        Thread {
            for (i in countValue downTo 0) {
                Log.d("Countdown", i.toString())
                Thread.sleep(100)
            }
            stopSelf()
        }.start()
    }

}