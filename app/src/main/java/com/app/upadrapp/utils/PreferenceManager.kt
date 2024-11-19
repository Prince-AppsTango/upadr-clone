package com.app.upadrapp.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceManager {
    private const val KEY_IS_LOGGED_IN = "isLoggedIn"
    private lateinit var preferences: SharedPreferences
    fun init(context: Context) {
        preferences = context.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE)
    }
    var isLoggedIn: Boolean
        get() = preferences.getBoolean(KEY_IS_LOGGED_IN, false)
        set(value) = preferences.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()
}
