package com.watermelonmann.cities.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.watermelonmann.cities.R
import com.watermelonmann.entity.CityEntity
import com.watermelonmann.ui.theme.ThemePreview
import com.watermelonmann.ui.theme.WeatherTheme

@Composable
internal fun CityView(
    city: CityEntity,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = city.name,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = stringResource(id = R.string.country, city.country),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@ThemePreview
@Composable
private fun CityViewPreview() {
    WeatherTheme {
        CityView(
            city = CityEntity(
                name = "London",
                country = "UK",
                latitude = 0.0,
                longitude = 0.0
            )
        )
    }
}