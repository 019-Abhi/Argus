package com.example.argus

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

private val monthNames = listOf(
    "Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
)

private val dayNames = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

fun LocalDate.asEventDate(): String {
    val dayName = dayNames[dayOfWeek.ordinal]
    val monthName = monthNames[month.ordinal]
    return "$dayName, $day $monthName"
}

fun LocalDate.asEventDateLong(): String {
    val monthName = monthNames[month.ordinal]
    return "$day $monthName $year"
}

fun LocalTime.asEventTime(): String {
    val suffix = if (hour < 12) "AM" else "PM"
    val twelveHour = when (val value = hour % 12) {
        0 -> 12
        else -> value
    }
    return "$twelveHour:${minute.toString().padStart(2, '0')} $suffix"
}
