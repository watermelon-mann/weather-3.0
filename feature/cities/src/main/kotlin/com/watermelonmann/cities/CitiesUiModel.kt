package com.watermelonmann.cities

import androidx.compose.runtime.Immutable
import com.watermelonmann.entity.CityEntity

@Immutable
internal data class CitiesUiModel(
    val cities: List<CityEntity> = emptyList(),
    val searchQuery: String = "",
    val screenState: ScreenState = ScreenState.HINT
)

internal enum class ScreenState {
    HINT,
    LOADING,
    ERROR,
    EMPTY,
    CONTENT
}