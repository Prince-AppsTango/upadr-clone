package com.app.upadrapp.utils

import com.google.gson.Gson
import com.google.gson.JsonObject

fun parseMessage(errorBody: String?): String {
    return try {
        val jsonObject = Gson().fromJson(errorBody, JsonObject::class.java)
        jsonObject["message"]?.asString ?: "An error occurred"
    } catch (e: Exception) {
        "An error occurred"
    }
}
