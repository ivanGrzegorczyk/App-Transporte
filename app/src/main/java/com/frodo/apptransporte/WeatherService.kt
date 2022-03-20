@file:Suppress("DEPRECATION")

package com.frodo.apptransporte

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

@Suppress("DEPRECATION")
class WeatherService : IntentService("Weather service") {

    // IntentService vs Service
    // Se elimina solo después de hacer su tarea
    // Genera un nuevo thread por si solo

    companion object {
        const val TAG = "WeatherService"
        const val ACTION_TEMPERATURE = "com.frodo.apptransporte.temperaturaLista"
        const val EXTRA_TEMPERATURE = "temperature"
    }

    // Main thread
    override fun onCreate() {
        Log.d(TAG, "onCreate")
        super.onCreate()
    }

    // Main thread
    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    // Worker thread
    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent")
        val queue = Volley.newRequestQueue(this)
        val city = intent?.getStringExtra("city") ?: "buenos aires"
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=13617b4d42b9faa1f9a330cd8d34ab65&units=metric"

        // Request a string response from the provided URL.
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            {
                val temperature = it.getJSONObject("main").getDouble("temp")

                val broadcastIntent = Intent(ACTION_TEMPERATURE)
                broadcastIntent.putExtra("temperature", temperature)
                sendBroadcast(broadcastIntent)
            },
            {  })

        // Add the request to the RequestQueue.
        queue.add(request)
    }

}