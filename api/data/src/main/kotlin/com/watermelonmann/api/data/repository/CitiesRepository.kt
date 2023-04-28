package com.watermelonmann.api.data.repository

import com.watermelonmann.entity.CityEntity
import kotlinx.coroutines.flow.Flow

interface CitiesRepository {
    fun getCities(name: String, limit: Int): Flow<List<CityEntity>>
}