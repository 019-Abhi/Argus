package com.example.argus

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object ArgusColors {
    val BackgroundTop = Color(0xFF171B2A)
    val BackgroundBottom = Color(0xFF0D101A)
    val Surface = Color(0xFF202536)
    val Glass = Color(0x1FFFFFFF)
    val GlassStrong = Color(0x2AFFFFFF)
    val Outline = Color(0x24FFFFFF)
    val TextPrimary = Color(0xFFF3F4F7)
    val TextSecondary = Color(0xFFAFB5C5)
    val Accent = Color(0xFF9BA8D8)
    val AccentSoft = Color(0xFFBAC3E8)
    val Success = Color(0xFF9FC8B4)
}

private val ArgusColorScheme = darkColorScheme(
    primary = ArgusColors.Accent,
    onPrimary = Color(0xFF151927),
    secondary = ArgusColors.AccentSoft,
    background = ArgusColors.BackgroundBottom,
    onBackground = ArgusColors.TextPrimary,
    surface = ArgusColors.Surface,
    onSurface = ArgusColors.TextPrimary,
    onSurfaceVariant = ArgusColors.TextSecondary,
    outline = ArgusColors.Outline,
)

@Composable
fun ArgusTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ArgusColorScheme,
        content = content,
    )
}
