package com.watermelonmann.domain.usecase

import com.watermelonmann.api.data.repository.CitiesRepository
import com.watermelonmann.entity.CityEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SearchCitiesUseCase @Inject constructor(
    private val citiesRepository: CitiesRepository
) {

    operator fun invoke(name: String, limit: Int): Flow<List<CityEntity>> =
        citiesRepository.getCities(name, limit)
}