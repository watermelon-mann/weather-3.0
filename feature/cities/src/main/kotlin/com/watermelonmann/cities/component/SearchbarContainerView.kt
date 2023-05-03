package com.watermelonmann.cities.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.watermelonmann.ui.theme.ThemePreview

@Composable
internal fun SearchbarContainerView(
    modifier: Modifier = Modifier,
    searchText: String,
    searchBarHint: String,
    onTextChange: (String) -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchbarView(
            searchText = searchText,
            hint = searchBarHint,
            onTextChange = onTextChange
        )
        content()
    }
}

@ThemePreview
@Composable
private fun SearchbarContainerViewPreview() {
    SearchbarContainerView(
        searchText = "",
        searchBarHint = "Search",
        onTextChange = {}
    ) {

    }
}