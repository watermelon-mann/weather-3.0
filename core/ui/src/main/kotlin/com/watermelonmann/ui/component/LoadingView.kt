package com.watermelonmann.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.watermelonmann.ui.theme.ThemePreview
import com.watermelonmann.ui.theme.WeatherPreviewTheme

@Composable
fun LoadingView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@ThemePreview
@Composable
private fun LoadingViewPreview() {
    WeatherPreviewTheme {
        LoadingView()
    }
}