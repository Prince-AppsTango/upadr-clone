package com.app.upadrapp.utils


import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

// reference from here https://firebase.google.com/docs/cloud-messaging/android/receive + CHAT GPT
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.app.upadrapp.MainActivity
import com.app.upadrapp.R


class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val CHANNEL_ID = "ForegroundNotificationChannel"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d("MyFirebaseMsgService", "From: ${remoteMessage.from}")

        // Process the data payload
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("MyFirebaseMsgService", "Data Payload: ${remoteMessage.data}")
        }

        // Process the notification payload
        remoteMessage.notification?.let {
            Log.d("MyFirebaseMsgService", "Notification Payload - Title: ${it.title}, Body: ${it.body}")
            showNotification(it.title, it.body)
        }
    }

    @SuppressLint("MissingPermission")
    private fun showNotification(title: String?, body: String?) {
        // Create the Notification Channel (required for API 26+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Foreground Notifications"
            val descriptionText = "Channel for displaying foreground notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // Create the Intent to launch the app on notification click
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Build the notification
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.applogo) // Replace with your app's notification icon
            .setContentTitle(title ?: "Notification")
            .setContentText(body ?: "You have a new message.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        // Show the notification with a unique ID
        with(NotificationManagerCompat.from(this)) {
            notify(System.currentTimeMillis().hashCode(), builder.build())
        }
    }

}

