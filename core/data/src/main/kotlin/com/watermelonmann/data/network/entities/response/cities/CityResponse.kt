package com.watermelonmann.data.network.entities.response.cities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityResponse(
    @SerialName("country") val country: String,
    @SerialName("is_capital") val isCapital: Boolean,
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double,
    @SerialName("name") val name: String,
    @SerialName("population") val population: Int
)