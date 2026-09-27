package com.example.argus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlin.time.Clock

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadEvents()
    }

    private fun loadEvents(){
        viewModelScope.launch {
            delay(500)

            val fakeEvents = listOf(
                Event(
                    eventId = "1",
                    eventName = "Movie night",
                    eventDate = LocalDate(2026, 10, 3),
                    destination = "PVR Cinemas, Kochi",
                    eventHost = "Abhi",
                    memberCount = 4,
                    eventTime = Clock.System.now(),
                    maxMembers = 6
                ),
                Event(
                    eventId = "2",
                    eventName = "Trip to Munnar",
                    eventDate = LocalDate(2026, 10, 10),
                    destination = "Munnar Tea Gardens",
                    eventHost = "Abhi",
                    memberCount = 3,
                    eventTime = Clock.System.now(),
                    maxMembers = 5
                ),
            )
        }
    }
}