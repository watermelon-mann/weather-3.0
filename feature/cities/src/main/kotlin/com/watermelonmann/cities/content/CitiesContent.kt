package com.watermelonmann.cities.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.watermelonmann.cities.CitiesUiModel
import com.watermelonmann.cities.component.CityView
import com.watermelonmann.entity.CityEntity
import com.watermelonmann.ui.theme.ThemePreview
import com.watermelonmann.ui.theme.WeatherTheme

@Composable
internal fun CitiesContent(
    model: CitiesUiModel
) {
    LazyColumn {
        itemsIndexed(model.cities) { index, city ->
            if (index > 0) Spacer(modifier = Modifier.height(8.dp))
            CityView(
                city = city
            )
        }
        item {
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

@ThemePreview
@Composable
private fun CitiesContentPreview() {
    WeatherTheme {
        CitiesContent(
            model = CitiesUiModel(
                cities = listOf(
                    CityEntity(
                        name = "London",
                        country = "UK",
                        latitude = 0.0,
                        longitude = 0.0
                    ),
                    CityEntity(
                        name = "Moscow",
                        country = "RU",
                        latitude = 0.0,
                        longitude = 0.0
                    ),
                    CityEntity(
                        name = "Toronto",
                        country = "CA",
                        latitude = 0.0,
                        longitude = 0.0
                    ),
                    CityEntity(
                        name = "Paris",
                        country = "FR",
                        latitude = 0.0,
                        longitude = 0.0
                    ),
                    CityEntity(
                        name = "Berlin",
                        country = "GR",
                        latitude = 0.0,
                        longitude = 0.0
                    ),
                    CityEntity(
                        name = "Tokyo",
                        country = "JP",
                        latitude = 0.0,
                        longitude = 0.0
                    )
                )
            )
        )
    }
}