package com.frodo.apptransporte

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
        const val KEY_LOGIN = "login"
        const val KEY_LOGGED = "alreadyLogged"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonSignIn = findViewById<Button>(R.id.botonLogIn)
        val botonSignUp = findViewById<Button>(R.id.botonRegister)
        val editUser = findViewById<EditText>(R.id.editTextTextPersonName)
        val editPassword = findViewById<EditText>(R.id.password)
        val preferences = getSharedPreferences(KEY_LOGIN, Context.MODE_PRIVATE)
        val alreadyLogged = preferences.getBoolean(KEY_LOGGED, false)

        if (alreadyLogged) {
            goToHome()
        }

        botonSignIn.setOnClickListener {
            val user: String = editUser.text.toString()
            val password: String = editPassword.text.toString()

            API.login(user, password, this) { response: Boolean ->
                if (response) {
                    Log.d(TAG, getString(R.string.loginOk))
                    goToHome()
                    preferences.edit {
                        putBoolean(KEY_LOGGED, true)
                    }
                } else {
                    val alertFail =
                        AlertDialog.Builder(this).setTitle(getString(R.string.loginFail))
                            .setMessage(R.string.loginFailed)
                            .setPositiveButton(getString(R.string.accept)) { _, _ -> print("") }
                            .show()
                    alertFail.show()
                    Log.e(TAG, getString(R.string.loginFail))
                }
            }
        }
        botonSignUp.setOnClickListener {
            Toast.makeText(this, getString(R.string.notImplemented), Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}