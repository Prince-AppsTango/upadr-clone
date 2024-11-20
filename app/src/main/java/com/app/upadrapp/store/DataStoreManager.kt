package com.app.upadrapp.store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

// Preference Keys
val ACCESS_TOKEN = stringPreferencesKey("accessToken")
val refreshToken = stringPreferencesKey("refreshToken")

// Save data to DataStore
suspend fun saveToDataStore(context: Context,accessToken:String) {
    context.dataStore.edit { preferences ->
        preferences[ACCESS_TOKEN] = accessToken
    }
}

// Retrieve data from DataStore
fun getAccessToken(context: Context): Flow<String> {
    return context.dataStore.data.map { preferences ->
        preferences[ACCESS_TOKEN] ?: ""
    }
}
