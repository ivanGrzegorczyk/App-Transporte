package com.frodo.apptransporte

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.core.content.edit

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Home"
        setContentView(R.layout.activity_home)

        val weatherButton = findViewById<Button>(R.id.buttonWeather)
        weatherButton.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator = MenuInflater(this)
        inflator.inflate(R.menu.home, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.actionSignOut) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

            val preferences = getSharedPreferences(LoginActivity.KEY_LOGIN, Context.MODE_PRIVATE)
            preferences.edit {
                putBoolean(LoginActivity.KEY_LOGGED, false)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}