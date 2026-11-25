package com.example.argus

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Decorative branding behind a supplied indicator; navigation stays with the caller. */
@Composable
fun BrandedPagerFooter(
    modifier: Modifier = Modifier,
    indicator: @Composable () -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp)
            .height(104.dp),
        contentAlignment = Alignment.Center,
    ) {
        // Size to the available width, with a cap for tablets and landscape windows.
        val wordmarkSize = (maxWidth.value / 4.2f).coerceAtMost(96f).sp
        Text(
            text = "ARGUS",
            color = ArgusColors.TextPrimary.copy(alpha = 0.08f),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            fontSize = wordmarkSize,
            letterSpacing = 3.sp,
            maxLines = 1,
            modifier = Modifier.clearAndSetSemantics { },
        )
        indicator()
    }
}
