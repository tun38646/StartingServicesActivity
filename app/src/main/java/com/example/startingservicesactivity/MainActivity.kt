package com.example.startingservicesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val countValue = findViewById<EditText>(R.id.editTextText).text.toString().toIntOrNull() ?: 0
            val serviceIntent = Intent(this, TimerService::class.java)

            serviceIntent.putExtra("countValue", countValue)
            startService(serviceIntent)
        }

    }
}