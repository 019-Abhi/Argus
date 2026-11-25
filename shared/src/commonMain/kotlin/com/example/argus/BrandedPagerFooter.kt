package com.example.argus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import argus.shared.generated.resources.ephesis
import argus.shared.generated.resources.Res
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.Font


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
        val wordmarkSize = (maxWidth.value / 4.2f).coerceAtMost(96f).sp
        Text(
            text = "Argus",
            color = ArgusColors.TextPrimary.copy(alpha = 0.08f),
            fontFamily = FontFamily(Font(Res.font.ephesis)),
            fontSize = 75.sp,
            textAlign = TextAlign.Center,
            letterSpacing = 2.sp,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp, horizontal = 0.dp)

        )
        indicator()
    }
}
