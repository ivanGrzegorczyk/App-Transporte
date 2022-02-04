package com.frodo.apptransporte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonSignIn = findViewById<Button>(R.id.botonLogIn)
        val botonSignUp = findViewById<Button>(R.id.botonRegister)
        val editUsuario = findViewById<EditText>(R.id.editTextTextPersonName)
        val editPassword = findViewById<EditText>(R.id.password)

        botonSignIn.setOnClickListener {
            val usuario = editUsuario.text.toString()
            val password = editPassword.text.toString()

            if (usuario.lowercase(Locale.getDefault()) == getString(R.string.strUsername) && password.lowercase(
                    Locale.getDefault()
                ) == getString(R.string.strPassword)
            )
                Toast.makeText(this, getString(R.string.loginCorrect), Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, getString(R.string.loginFailed), Toast.LENGTH_SHORT).show()
        }
        botonSignUp.setOnClickListener {
            Toast.makeText(this, getString(R.string.notImplemented), Toast.LENGTH_SHORT).show()
        }
    }
}