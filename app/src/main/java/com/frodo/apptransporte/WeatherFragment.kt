package com.frodo.apptransporte

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class WeatherFragment : Fragment() {

    var textTemperature: TextView? = null
    private val receiver = object : BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        override fun onReceive(context: Context?, intent: Intent?) {
            val temperature =
                intent?.extras?.getDouble(WeatherService.EXTRA_TEMPERATURE, -200.0) ?: -200.0
            if (temperature < -100) {
                textTemperature?.text = getString(R.string.errorMessage)
            } else {
                textTemperature?.text = "$temperature°C"
            }
        }
    }

    override fun onResume() {
        // ESCUCHA UN BROADCAST - BROADCAST RECEIVER
        val intentFilter = IntentFilter(WeatherService.ACTION_TEMPERATURE)
        activity?.registerReceiver(receiver, intentFilter)

        super.onResume()
    }

    override fun onPause() {
        activity?.unregisterReceiver(receiver)

        super.onPause()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_weather, container, false)
        val buttonCity = rootView.findViewById<Button>(R.id.buttonCity)
        val editTextCity = rootView.findViewById<EditText>(R.id.editTextCity)
        textTemperature = rootView.findViewById(R.id.textTemperature)

        buttonCity.setOnClickListener {
            val city = editTextCity.text.toString()
            textTemperature?.text = getString(R.string.loadingEmoji)

            // COMIENZA UN SERVICIO
            val intent = Intent(activity, WeatherService::class.java)
            intent.putExtra(getString(R.string.cityValue), city)
            activity?.startService(intent)
        }

        return rootView
    }
}