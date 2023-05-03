package com.watermelonmann.cities.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.watermelonmann.ui.theme.ThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchbarView(
    searchText: String,
    hint: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = onTextChange,
            label = { Text(hint) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@ThemePreview
@Composable
private fun SearchbarViewPreview() {
    SearchbarView(
        searchText = "",
        hint = "Hint",
        onTextChange = {}
    )
}