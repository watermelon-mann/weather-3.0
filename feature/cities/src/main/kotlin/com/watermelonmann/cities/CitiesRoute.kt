package com.watermelonmann.cities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.watermelonmann.ui.naviagation.NavRoute

object CitiesRoute : NavRoute<CitiesViewModel> {

    override val route: String = "cities"

    @Composable
    override fun Content(viewModel: CitiesViewModel, navController: NavController) {
        val state by viewModel.state.collectAsStateWithLifecycle()
        CitiesScreen(
            model = state,
            onSearchInputChange = viewModel::searchCity
        )
    }

    @Composable
    override fun viewModel(): CitiesViewModel = hiltViewModel()
}