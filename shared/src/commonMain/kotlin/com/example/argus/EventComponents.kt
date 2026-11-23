package com.example.argus

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

private val EventCardShape = RoundedCornerShape(30.dp)

@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .shadow(
                elevation = 24.dp,
                shape = EventCardShape,
                ambientColor = Color.Black.copy(alpha = 0.42f),
                spotColor = Color.Black.copy(alpha = 0.5f),
            )
            .clip(EventCardShape)
            .background(ArgusColors.Surface)
            .border(1.dp, ArgusColors.Outline, EventCardShape)
            .clickable(onClick = onClick),
    ) {
        EventHeroImage(
            event = event,
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp),
        )

        Column(
            modifier = Modifier.padding(horizontal = 22.dp, vertical = 18.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                EventStatusPill()
                Text(
                    text = "${event.memberCount}/${event.maxMembers} going",
                    color = ArgusColors.TextSecondary,
                    style = MaterialTheme.typography.labelLarge,
                )
            }

            Spacer(Modifier.height(13.dp))

            Text(
                text = event.eventName,
                color = ArgusColors.TextPrimary,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = (-0.4).sp,
            )
            Text(
                text = "Created by ${event.eventHost}",
                color = ArgusColors.TextSecondary,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 3.dp),
            )

            Spacer(Modifier.height(14.dp))

            EventInfoRow(
                icon = Icons.Default.CalendarMonth,
                text = event.eventDate.asEventDate(),
                trailingText = event.eventTime.asEventTime(),
            )
            EventInfoRow(
                icon = Icons.Default.LocationOn,
                text = event.destination,
            )
            EventInfoRow(
                icon = Icons.Default.Groups,
                text = "${event.memberCount} friends are joining",
            )

            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(ArgusColors.Glass)
                    .border(1.dp, ArgusColors.Outline, RoundedCornerShape(18.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Open event",
                    color = ArgusColors.AccentSoft,
                    fontWeight = FontWeight.SemiBold,
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = ArgusColors.AccentSoft,
                    modifier = Modifier.size(19.dp),
                )
            }
        }
    }
}

@Composable
fun EventHeroImage(
    event: Event,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(event.coverResource()),
            contentDescription = "Cover photo for ${event.eventName}",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize(),
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        0f to Color.Transparent,
                        0.62f to Color.Transparent,
                        1f to ArgusColors.Surface.copy(alpha = 0.74f),
                    )
                ),
        )
    }
}

@Composable
private fun EventStatusPill() {
    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(ArgusColors.GlassStrong)
            .border(1.dp, ArgusColors.Outline, CircleShape)
            .padding(horizontal = 11.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(7.dp)
                .clip(CircleShape)
                .background(ArgusColors.Success),
        )
        Text(
            text = "Upcoming",
            color = ArgusColors.TextPrimary,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
private fun EventInfoRow(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    trailingText: String? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(11.dp))
                .background(ArgusColors.Glass),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = ArgusColors.AccentSoft,
                modifier = Modifier.size(18.dp),
            )
        }
        Text(
            text = text,
            color = ArgusColors.TextPrimary,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp),
            maxLines = 1,
        )
        trailingText?.let {
            Icon(
                imageVector = Icons.Default.Schedule,
                contentDescription = null,
                tint = ArgusColors.TextSecondary,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(16.dp),
            )
            Text(
                text = it,
                color = ArgusColors.TextSecondary,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 5.dp),
            )
        }
    }
}
