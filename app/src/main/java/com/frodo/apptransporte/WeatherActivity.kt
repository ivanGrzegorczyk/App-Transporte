package com.frodo.apptransporte

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Weather"
        setContentView(R.layout.activity_weather)
    }
}


