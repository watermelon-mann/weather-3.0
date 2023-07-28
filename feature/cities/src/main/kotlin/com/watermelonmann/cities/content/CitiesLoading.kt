package com.watermelonmann.cities.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.watermelonmann.ui.component.LoadingView
import com.watermelonmann.ui.theme.ThemePreview
import com.watermelonmann.ui.theme.WeatherPreviewTheme

@Composable
internal fun CitiesLoading() {
    LoadingView(
        modifier = Modifier.fillMaxSize()
    )
}

@ThemePreview
@Composable
private fun CitiesLoadingPreview() {
    WeatherPreviewTheme {
        CitiesLoading()
    }
}