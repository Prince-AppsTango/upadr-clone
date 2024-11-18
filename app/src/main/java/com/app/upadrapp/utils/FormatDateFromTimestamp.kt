package com.app.upadrapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDateFromTimestamp(timestamp: Long): String {
    val date = Date(timestamp)
    val format = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return format.format(date)
}
