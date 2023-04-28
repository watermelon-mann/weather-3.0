package com.watermelonmann.data.di

import com.watermelonmann.api.data.repository.CitiesRepository
import com.watermelonmann.data.repository.CitiesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCitiesRepository(impl: CitiesRepositoryImpl): CitiesRepository

}