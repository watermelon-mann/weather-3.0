package com.watermelonmann.data_mock.repository

import com.watermelonmann.api.data.repository.CitiesRepository
import com.watermelonmann.entity.CityEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCitiesRepository : CitiesRepository {

    private val cities = listOf(
        cityEntity("London", "UK"),
        cityEntity("Moscow", "RU"),
        cityEntity("Toronto", "CA"),
        cityEntity("Paris", "FR"),
        cityEntity("Berlin", "GR"),
        cityEntity("Tokyo", "JP")
    )

    override fun getCities(name: String, limit: Int): Flow<List<CityEntity>> = flow {
        val cities = cities
            .filter { it.name.contains(name, ignoreCase = true) }
            .take(limit)

        emit(cities)
    }
}


private fun cityEntity(name: String, country: String) = CityEntity(
    name = name,
    country = country,
    latitude = 0.0,
    longitude = 0.0
)