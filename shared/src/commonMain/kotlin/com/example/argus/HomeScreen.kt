package com.example.argus

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onEventClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    MaterialTheme {
        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(uiState.events) { event ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onEventClick(event.eventId) }
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(event.eventName, style = MaterialTheme.typography.titleMedium)
                            Text(event.destination, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}