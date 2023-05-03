package com.watermelonmann.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.watermelonmann.ui.theme.LocalBackgroundTheme

@Composable
fun WeatherBackground(
    content: @Composable () -> Unit
) {
    Surface(
        color = LocalBackgroundTheme.current.color,
        modifier = Modifier.fillMaxSize(),
        content = content
    )
}