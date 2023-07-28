package com.watermelonmann.domain

import com.watermelonmann.data_mock.repository.FakeCitiesRepository
import com.watermelonmann.domain.usecase.SearchCitiesUseCase
import com.watermelonmann.entity.CityEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SearchCitiesTest {

    private lateinit var searchCitiesUseCase: SearchCitiesUseCase

    @Before
    fun setup() {
        searchCitiesUseCase = SearchCitiesUseCase(
            citiesRepository = FakeCitiesRepository()
        )
    }

    @Test
    fun `Search cities, success`() = runTest {
        val cities: List<CityEntity> = searchCitiesUseCase("lon", 1).first()

        assertTrue(cities.size == 1)
        assertTrue(cities.first().name.contains("lon", ignoreCase = true))
    }

    @Test
    fun `Search cities, search with white space`() = runTest {
        val cities = searchCitiesUseCase("    lon    ", 1).first()

        assertTrue(cities.size == 1)
        assertTrue(cities.first().name.contains("lon", ignoreCase = true))
    }
}