package com.app.upadrapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun formatDateFromTimestamp(timestamp: Long): String {
    val date = Date(timestamp)
    val format = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return format.format(date)
}

// copy from chat gpt
fun combineDateTimeToISO(selectedDate: String, selectedTime: String): String? {
    try {
        val dateFormatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        val timeFormatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        val isoFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        isoFormatter.timeZone = TimeZone.getTimeZone("UTC")

        val date = dateFormatter.parse(selectedDate)
        val time = timeFormatter.parse(selectedTime)

        if (date != null && time != null) {
            val calendar = java.util.Calendar.getInstance()
            calendar.time = date
            val dateOnly = calendar.clone() as java.util.Calendar

            calendar.time = time
            dateOnly.set(java.util.Calendar.HOUR_OF_DAY, calendar.get(java.util.Calendar.HOUR_OF_DAY))
            dateOnly.set(java.util.Calendar.MINUTE, calendar.get(java.util.Calendar.MINUTE))
            return isoFormatter.format(dateOnly.time)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}