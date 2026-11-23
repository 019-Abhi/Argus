package com.example.argus

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

data class Event(
    val eventId: String,
    val eventName: String,
    val eventDate: LocalDate,
    val eventTime: LocalTime,
    val destination: String,
    val eventHost: String,
    val memberCount: Int,
    val maxMembers: Int,
    val description: String,
    val imageUrl: String? = null,
)
