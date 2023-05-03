package com.watermelonmann.ui.di

import com.watermelonmann.ui.naviagation.RouteNavigator
import com.watermelonmann.ui.naviagation.RouteNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RouteNavigatorModule {

    @Binds
    fun bindRouteNavigator(impl: RouteNavigatorImpl): RouteNavigator

}