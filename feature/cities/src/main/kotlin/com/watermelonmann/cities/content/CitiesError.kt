package com.watermelonmann.cities.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.watermelonmann.cities.R
import com.watermelonmann.cities.component.MessageView
import com.watermelonmann.ui.theme.ThemePreview
import com.watermelonmann.ui.theme.WeatherPreviewTheme

@Composable
internal fun CitiesError() {
    MessageView(
        message = stringResource(id = R.string.something_went_wrong)
    )
}

@ThemePreview
@Composable
private fun CitiesErrorPreview() {
    WeatherPreviewTheme {
        CitiesError()
    }
}