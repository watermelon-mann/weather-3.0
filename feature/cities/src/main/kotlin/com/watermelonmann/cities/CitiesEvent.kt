package com.watermelonmann.cities

internal sealed interface CitiesEvent {
    data class Search(val query: String) : CitiesEvent
}