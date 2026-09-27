package com.example.argus

import kotlinx.datetime.*

data class Event(
    val eventId: String,
    val eventName: String,
    val eventDate: LocalDate,
    val destination: String,
    val eventHost: String,
    val memberCount: Int,
    val eventTime: Instant,
    val maxMembers: Int,
)