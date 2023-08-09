package com.watermelonmann.weather.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.watermelonmann.cities.CitiesRoute
import com.watermelonmann.ui.component.WeatherBackground

@Composable
fun WeatherApp() {
    WeatherBackground {
        Box(modifier = Modifier.safeDrawingPadding()) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = CitiesRoute.route
            ) {
                CitiesRoute.composable(this, navController)
            }
        }
    }
}