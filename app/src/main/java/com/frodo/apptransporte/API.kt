package com.frodo.apptransporte

import android.content.Context
import java.util.*

class API {
    companion object {
        fun login(
            user: String,
            password: String,
            context: Context,
            callback: (ok: Boolean) -> Unit
        ) {
            if (user.lowercase(Locale.getDefault()) == (context.getString(R.string.strUsername)).lowercase() && password == (context.getString(
                    R.string.strPassword
                ))
            )
                callback(true)
            else
                callback(false)
        }
    }
}