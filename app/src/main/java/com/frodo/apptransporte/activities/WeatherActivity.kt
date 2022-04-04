package com.frodo.apptransporte.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frodo.apptransporte.R

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Weather"
        setContentView(R.layout.activity_weather)
    }
}


