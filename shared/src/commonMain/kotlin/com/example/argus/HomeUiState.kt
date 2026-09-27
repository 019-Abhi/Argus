package com.example.argus

data class HomeUiState(
    val events: List<Event> = emptyList(),
    val isLoading: Boolean = false,
)
