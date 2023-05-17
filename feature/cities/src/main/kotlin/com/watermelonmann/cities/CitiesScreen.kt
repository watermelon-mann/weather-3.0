package com.watermelonmann.cities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.watermelonmann.cities.component.SearchbarContainerView
import com.watermelonmann.cities.content.CitiesContent
import com.watermelonmann.cities.content.CitiesEmpty
import com.watermelonmann.cities.content.CitiesError
import com.watermelonmann.cities.content.CitiesHint
import com.watermelonmann.cities.content.CitiesLoading

@Composable
internal fun CitiesScreen(state: CitiesScreenState) {
    val uiState by state.uiState.collectAsStateWithLifecycle()
    val eventHandler = state.eventHandler

    SearchbarContainerView(
        searchText = uiState.searchQuery,
        searchBarHint = stringResource(id = R.string.search),
        onTextChange = remember {
            { eventHandler(CitiesEvent.Search(it)) }
        }
    ) {
        when (uiState.screenState) {
            ScreenState.LOADING -> CitiesLoading()
            ScreenState.EMPTY -> CitiesEmpty(
                searchQuery = uiState.searchQuery
            )
            ScreenState.ERROR -> CitiesError()
            ScreenState.HINT -> CitiesHint()
            ScreenState.CONTENT -> CitiesContent(
                model = uiState
            )
        }
    }
}