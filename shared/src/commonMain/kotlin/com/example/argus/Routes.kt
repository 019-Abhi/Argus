package com.example.argus

import kotlinx.serialization.Serializable
import androidx.navigation3.runtime.NavKey

@Serializable
sealed interface Routes : NavKey {

    @Serializable
    data object HomeScreen : Routes

    @Serializable
    data class EventDetails(val eventId: String) : Routes
}