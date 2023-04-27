package com.watermelonmann.data.network.api

import com.watermelonmann.data.network.entities.response.cities.CityResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface CitiesAPIService {

    @GET("v1/city")
    fun getCities(
        @Query("name") name: String,
        @Query("limit") limit: Int
    ) : Flow<List<CityResponse>>
}