package com.watermelonmann.cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watermelonmann.domain.usecase.SearchCitiesUseCase
import com.watermelonmann.entity.CityEntity
import com.watermelonmann.ui.naviagation.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val searchCities: SearchCitiesUseCase,
    routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {

    private val _state = MutableStateFlow(CitiesUiModel())
    internal val state = _state.asStateFlow()

    private val searchQueries: Flow<String> = _state
        .map { it.searchQuery }
        .distinctUntilChanged()

    init {
        collectSearchQueries()
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    private fun collectSearchQueries() = searchQueries
        .onEach { query -> if (query.isBlank()) emitHintState() else emitLoading() }
        .debounce(SEARCH_DEBOUNCE)
        .filter { it.isNotBlank() }
        .flatMapLatest { searchCities(it, CITIES_LIMIT) }
        .flowOn(Dispatchers.IO)
        .onEach(::onSearchResult)
        .catch { emitError() }
        .launchIn(viewModelScope)

    internal fun onEvent(event: CitiesEvent) = when (event) {
        is CitiesEvent.Search -> searchCity(event.query)
    }

    private fun searchCity(query: String) = _state.update {
        it.copy(
            searchQuery = query
        )
    }

    private fun emitLoading() = _state.update {
        it.copy(
            screenState = ScreenState.LOADING
        )
    }

    private fun emitError() = _state.update {
        it.copy(
            screenState = ScreenState.ERROR
        )
    }

    private fun onSearchResult(cities: List<CityEntity>) {
        if (cities.isEmpty()) emitEmptyState() else emitCities(cities)
    }

    private fun emitEmptyState() = _state.update {
        it.copy(
            screenState = ScreenState.EMPTY,
            cities = emptyList()
        )
    }

    private fun emitCities(cities: List<CityEntity>) = _state.update {
        it.copy(
            screenState = ScreenState.CONTENT,
            cities = cities
        )
    }

    private fun emitHintState() = _state.update {
        it.copy(
            screenState = ScreenState.HINT
        )
    }

    companion object {
        private const val CITIES_LIMIT = 20
        private const val SEARCH_DEBOUNCE = 400L
    }

}