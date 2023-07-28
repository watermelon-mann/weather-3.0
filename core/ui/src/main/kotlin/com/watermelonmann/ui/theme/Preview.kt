package com.watermelonmann.ui.theme

import androidx.compose.runtime.Composable
import com.watermelonmann.ui.component.WeatherBackground

@Composable
fun WeatherPreviewTheme(
    content: @Composable () -> Unit
) {
    WeatherTheme {
        WeatherBackground(content = content)
    }
}