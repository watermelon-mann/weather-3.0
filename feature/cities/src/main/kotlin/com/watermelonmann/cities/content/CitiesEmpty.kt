package com.watermelonmann.cities.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.watermelonmann.cities.R
import com.watermelonmann.cities.component.MessageView
import com.watermelonmann.ui.theme.ThemePreview
import com.watermelonmann.ui.theme.WeatherTheme

@Composable
internal fun CitiesEmpty(
    searchQuery: String
) {
    MessageView(
        message = stringResource(id = R.string.no_results_found, searchQuery)
    )
}

@ThemePreview
@Composable
private fun CitiesEmptyPreview() {
    WeatherTheme {
        CitiesEmpty(
            "New York"
        )
    }
}