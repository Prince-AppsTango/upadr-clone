package com.app.upadrapp.shared

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
fun FetchFcmToken(onTokenReceived: (String) -> Unit) {
    FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
        if (!task.isSuccessful) {
            Log.w("FCM", "Fetching FCM registration token failed", task.exception)
            return@addOnCompleteListener
        }

        // Get the FCM token
        val token = task.result
        Log.d("FCM", "FCM Token: $token")
        onTokenReceived(token)
    }
}