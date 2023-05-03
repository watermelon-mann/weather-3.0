package com.watermelonmann.cities

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.watermelonmann.cities.component.SearchbarContainerView
import com.watermelonmann.cities.content.CitiesContent
import com.watermelonmann.cities.content.CitiesEmpty
import com.watermelonmann.cities.content.CitiesError
import com.watermelonmann.cities.content.CitiesHint
import com.watermelonmann.cities.content.CitiesLoading

@Composable
internal fun CitiesScreen(
    model: CitiesUiModel,
    onSearchInputChange: (String) -> Unit
) {
    SearchbarContainerView(
        searchText = model.searchQuery,
        searchBarHint = stringResource(id = R.string.search),
        onTextChange = onSearchInputChange
    ) {
        when (model.screenState) {
            ScreenState.LOADING -> CitiesLoading()
            ScreenState.EMPTY -> CitiesEmpty(model.searchQuery)
            ScreenState.ERROR -> CitiesError()
            ScreenState.HINT -> CitiesHint()
            ScreenState.CONTENT -> CitiesContent(
                model = model
            )
        }
    }


}