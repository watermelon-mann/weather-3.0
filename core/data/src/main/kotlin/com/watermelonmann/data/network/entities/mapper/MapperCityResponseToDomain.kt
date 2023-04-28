package com.watermelonmann.data.network.entities.mapper

import com.watermelonmann.common.mapper.Mapper
import com.watermelonmann.data.network.entities.response.cities.CityResponse
import com.watermelonmann.entity.CityEntity

class MapperCityResponseToDomain : Mapper<CityResponse, CityEntity> {
    override fun map(from: CityResponse): CityEntity = from.run {
        CityEntity(
            name = name,
            latitude = latitude,
            longitude = longitude,
            country = country
        )
    }
}