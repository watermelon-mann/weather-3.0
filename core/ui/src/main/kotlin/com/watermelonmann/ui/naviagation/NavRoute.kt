package com.watermelonmann.ui.naviagation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


interface NavRoute<T : RouteNavigator> {

    val route: String


    @Composable
    fun Content(viewModel: T, navController: NavController)

    @Composable
    fun viewModel(): T

    fun getArguments(): List<NamedNavArgument> = listOf()

    fun composable(
        builder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        builder.composable(route, getArguments()) {
            val viewModel = viewModel()
            initRoute(viewModel, navHostController)
            Content(viewModel, navHostController)
        }
    }

    @Composable
    private fun initRoute(
        viewModel: T,
        navHostController: NavHostController
    ) {
        val viewStateAsState by viewModel.navigationState.collectAsState()

        LaunchedEffect(viewStateAsState) {
            Log.d("Nav", "${this@NavRoute} updateNavigationState to $viewStateAsState")
            updateNavigationState(navHostController, viewStateAsState, viewModel::onNavigated)
        }
    }

    private fun updateNavigationState(
        navHostController: NavHostController,
        navigationState: NavigationState,
        onNavigated: (navState: NavigationState) -> Unit,
    ) {
        when (navigationState) {
            is NavigationState.NavigateToRoute -> {
                navHostController.navigate(navigationState.route)
                onNavigated(navigationState)
            }
            is NavigationState.PopToRoute -> {
                navHostController.popBackStack(navigationState.staticRoute, false)
                onNavigated(navigationState)
            }
            is NavigationState.NavigateUp -> navHostController.navigateUp()
            is NavigationState.Idle -> Unit
        }
    }
}

fun <T> SavedStateHandle.getOrThrow(key: String): T =
    get<T>(key) ?: throw IllegalArgumentException(
        "Mandatory argument $key missing in arguments."
    )