package com.example.argus

import argus.shared.generated.resources.Res
import argus.shared.generated.resources.ephesis
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.Font


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onEventClick: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(ArgusColors.BackgroundTop, ArgusColors.BackgroundBottom),
                )
            ),
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator(
                color = ArgusColors.Accent,
                modifier = Modifier.align(Alignment.Center),
            )
        } else {
            EventDashboard(
                events = uiState.events,
                onEventClick = onEventClick,
                onCreateEvent = { /* Creation flow will be implemented separately. */ },
            )
        }
    }
}

@Composable
private fun EventDashboard(
    events: List<Event>,
    onEventClick: (String) -> Unit,
    onCreateEvent: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { events.size })

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopBar()

        Text(
            text = "You have ${events.size} upcoming ${if (events.size == 1) "plan" else "plans"}",
            color = ArgusColors.TextSecondary,
            fontFamily = FontFamily(Font(Res.font.ephesis)),
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 30.dp)
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 22.dp),
            pageSpacing = 14.dp,
            verticalAlignment = Alignment.Top,
        ) { page ->
            EventCard(
                event = events[page],
                onClick = { onEventClick(events[page].eventId) },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        PagerIndicator(
            pageCount = events.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 60.dp),
        )
    }
}

@Composable
private fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(ArgusColors.Glass)
            .border(1.dp, ArgusColors.Outline, CircleShape)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
    ) {
        repeat(pageCount) { page ->
            Box(
                modifier = Modifier
                    .size(width = if (page == currentPage) 18.dp else 6.dp, height = 6.dp)
                    .clip(CircleShape)
                    .background(
                        if (page == currentPage) ArgusColors.Accent
                        else ArgusColors.TextSecondary.copy(alpha = 0.45f)
                    ),
            )
        }
    }
}
