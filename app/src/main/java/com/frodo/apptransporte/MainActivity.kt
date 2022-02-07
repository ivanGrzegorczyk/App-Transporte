package com.frodo.apptransporte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonSignIn = findViewById<Button>(R.id.botonLogIn)
        val botonSignUp = findViewById<Button>(R.id.botonRegister)
        val editUsuario = findViewById<EditText>(R.id.editTextTextPersonName)
        val editPassword = findViewById<EditText>(R.id.password)

        botonSignIn.setOnClickListener {
            val user: String = editUsuario.text.toString()
            val password: String = editPassword.text.toString()
            val alertaFail =
                AlertDialog.Builder(this).setTitle(getString(R.string.loginFail))
                    .setMessage(R.string.loginFailed)
                    .setPositiveButton(getString(R.string.accept)) { _, _ -> print("hola") }

            API.login(user, password, this) { respuesta: Boolean ->
                if (respuesta) {
                    Toast.makeText(this, getString(R.string.loginCorrect), Toast.LENGTH_SHORT)
                        .show()
                    Log.d(TAG, getString(R.string.loginOk))
                } else {
                    alertaFail.show()
                    Log.e(TAG, getString(R.string.loginFail))
                }
            }
        }
        botonSignUp.setOnClickListener {
            Toast.makeText(this, getString(R.string.notImplemented), Toast.LENGTH_SHORT).show()
        }
    }
}