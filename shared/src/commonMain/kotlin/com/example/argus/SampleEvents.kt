package com.example.argus

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

/**
 * Temporary in-memory data used while Argus has no repository or backend.
 * Keeping it outside the ViewModel lets multiple screens resolve the same event.
 */
object SampleEvents {
    val all = listOf(
        Event(
            eventId = "1",
            eventName = "Movie night",
            eventDate = LocalDate(2026, 12, 6),
            eventTime = LocalTime(19, 30),
            destination = "PVR Cinemas, Kochi",
            eventHost = "Abhi",
            memberCount = 4,
            maxMembers = 6,
            description = "A relaxed Sunday movie with the group. Meet near the main lobby before showtime.",
            imageUrl = MovieNightArtwork,
        ),
        Event(
            eventId = "2",
            eventName = "Munnar road trip",
            eventDate = LocalDate(2026, 12, 13),
            eventTime = LocalTime(6, 30),
            destination = "Munnar Tea Gardens",
            eventHost = "Abhi",
            memberCount = 3,
            maxMembers = 5,
            description = "An early drive through the hills, with breakfast and photo stops along the way.",
            imageUrl = MunnarTripArtwork,
        ),
        Event(
            eventId = "3",
            eventName = "Cherry blossom walk",
            eventDate = LocalDate(2027, 3, 28),
            eventTime = LocalTime(16, 0),
            destination = "Osaka Castle Park",
            eventHost = "Maya",
            memberCount = 2,
            maxMembers = 4,
            description = "A slow afternoon walk under the blossoms, ending with dinner near the park.",
            imageUrl = CherryBlossomArtwork,
        ),
    )

    fun findById(eventId: String): Event? = all.firstOrNull { it.eventId == eventId }
}
