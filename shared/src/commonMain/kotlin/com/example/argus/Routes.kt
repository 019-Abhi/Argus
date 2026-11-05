package com.example.argus

import kotlinx.serialization.Serializable
import androidx.navigation3.runtime.NavKey

@Serializable
sealed interface Routes : NavKey {

    @Serializable
    data object HomeRoute : Routes

    @Serializable
    data class EventPage(val eventId: String) : Routes
}