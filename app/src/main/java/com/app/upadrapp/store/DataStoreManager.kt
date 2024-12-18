package com.app.upadrapp.store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val Context.dataStore by preferencesDataStore(name = "settings")

// Preference Keys
val ACCESS_TOKEN = stringPreferencesKey("accessToken")
val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")

// Save data to DataStore
suspend fun saveToDataStore(context: Context,accessToken:String,refreshToken: String) {
    context.dataStore.edit { preferences ->
        preferences[ACCESS_TOKEN] = accessToken
        preferences[REFRESH_TOKEN] = refreshToken
    }
}

// Retrieve access token
fun getAccessToken(context: Context): Flow<String> {
    return context.dataStore.data.map { preferences ->
        preferences[ACCESS_TOKEN] ?: ""
    }
}

//Retrieve refresh token

fun getRefreshToken(context: Context): Flow<String> {
    return context.dataStore.data.map { preferences ->
        preferences[REFRESH_TOKEN]?:""
    }
}

// copy from the google
fun getAccessTokenSync(context: Context): String {
    return runBlocking {
        context.dataStore.data
            .map { preferences -> preferences[ACCESS_TOKEN] ?: "" }
            .first()
    }
}