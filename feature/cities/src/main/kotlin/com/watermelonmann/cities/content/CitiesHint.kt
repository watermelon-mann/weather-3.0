package com.watermelonmann.cities.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.watermelonmann.cities.R
import com.watermelonmann.cities.component.MessageView
import com.watermelonmann.ui.theme.ThemePreview
import com.watermelonmann.ui.theme.WeatherTheme

@Composable
internal fun CitiesHint() {
    MessageView(
        message = stringResource(id = R.string.type_to_search)
    )
}

@ThemePreview
@Composable
private fun CitiesHintPreview() {
    WeatherTheme {
        CitiesHint()
    }
}