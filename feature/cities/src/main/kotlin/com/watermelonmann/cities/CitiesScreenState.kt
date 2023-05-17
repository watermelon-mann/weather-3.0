package com.watermelonmann.cities

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.StateFlow

@Stable
internal data class CitiesScreenState(
    val uiState: StateFlow<CitiesUiModel>,
    val eventHandler: (CitiesEvent) -> Unit
)