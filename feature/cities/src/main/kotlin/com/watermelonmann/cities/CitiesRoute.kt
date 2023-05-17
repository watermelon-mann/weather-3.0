package com.watermelonmann.cities

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.watermelonmann.ui.naviagation.NavRoute

object CitiesRoute : NavRoute<CitiesViewModel> {

    override val route: String = "cities"

    @Composable
    override fun Content(viewModel: CitiesViewModel, navController: NavController) =
        CitiesScreen(viewModel.state)

    @Composable
    override fun viewModel(): CitiesViewModel = hiltViewModel()
}