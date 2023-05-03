package com.watermelonmann.weather.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.watermelonmann.cities.CitiesRoute
import com.watermelonmann.ui.component.WeatherBackground

@Composable
fun WeatherApp() {
    WeatherBackground {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = CitiesRoute.route
        ) {
            CitiesRoute.composable(this, navController)
        }
    }
}