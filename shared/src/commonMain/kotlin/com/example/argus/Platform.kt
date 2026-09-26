package com.example.argus

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform