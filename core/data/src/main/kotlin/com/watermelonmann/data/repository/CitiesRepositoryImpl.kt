package com.watermelonmann.data.repository

import com.watermelonmann.api.data.repository.CitiesRepository
import com.watermelonmann.data.network.api.CitiesAPIService
import com.watermelonmann.data.network.entities.mapper.MapperCityResponseToDomain
import com.watermelonmann.entity.CityEntity
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Singleton
class CitiesRepositoryImpl @Inject constructor(
    private val apiService: CitiesAPIService
) : CitiesRepository {

    override fun getCities(name: String, limit: Int): Flow<List<CityEntity>> =
        apiService.getCities(name, limit)
            .map(MapperCityResponseToDomain()::map)
}