package com.example.argus

import argus.shared.generated.resources.Res
import argus.shared.generated.resources.cherry_blossom_cover
import argus.shared.generated.resources.movie_night_cover
import argus.shared.generated.resources.munnar_trip_cover
import org.jetbrains.compose.resources.DrawableResource

const val MovieNightArtwork = "asset://movie-night-cover"
const val MunnarTripArtwork = "asset://munnar-trip-cover"
const val CherryBlossomArtwork = "asset://cherry-blossom-cover"

fun Event.coverResource(): DrawableResource = when (imageUrl) {
    MunnarTripArtwork -> Res.drawable.munnar_trip_cover
    CherryBlossomArtwork -> Res.drawable.cherry_blossom_cover
    else -> Res.drawable.movie_night_cover
}
