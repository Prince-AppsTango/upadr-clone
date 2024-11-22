package com.app.upadrapp.shared

import java.util.concurrent.TimeUnit
// help from chat gpt
fun ConvertToDateCount(timeStr: String): String {
    // Split the input string into hours, minutes, and seconds
    val (hours, minutes, seconds) = timeStr.split(":").map { it.toInt() }
    // Get the current time in milliseconds
    val currentTime = System.currentTimeMillis()
    // Calculate the target time in milliseconds
    val targetTime = currentTime + TimeUnit.HOURS.toMillis(hours.toLong()) +
            TimeUnit.MINUTES.toMillis(minutes.toLong()) +
            TimeUnit.SECONDS.toMillis(seconds.toLong())
    // Calculate the time difference
    val differenceInMillis = targetTime - currentTime
    // Convert the difference to hours
    val differenceInHours = differenceInMillis.toDouble() / (1000 * 60 * 60)
    return if (differenceInHours >= 24) {
        // If the difference is 24 hours or more, return the number of days
        val differenceInDays = (differenceInHours / 24).toInt()
        "$differenceInDays days"
    } else {
        // Otherwise, return the number of hours
        "${differenceInHours.toInt()} hours"
    }
}
