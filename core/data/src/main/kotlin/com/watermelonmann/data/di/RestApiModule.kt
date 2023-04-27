package com.watermelonmann.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.watermelonmann.data.BuildConfig
import com.watermelonmann.data.network.FlowCallAdapterFactory
import com.watermelonmann.data.network.api.CitiesAPIService
import com.watermelonmann.data.network.interceptor.CitiesAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RestApiModule {

    private const val TIMEOUT_CONNECTION_SECONDS = 20L
    private const val TIMEOUT_READ_SECONDS = 20L
    private const val TIMEOUT_WRITE_SECONDS = 20L

    @Provides
    @Singleton
    fun provideCitiesAPIService(
        @RetrofitClientCities retrofit: Retrofit
    ): CitiesAPIService = createApiService(retrofit)

    @Provides
    @Singleton
    @RetrofitClientCities
    fun provideCitiesRetrofitClient(
        clientBuilder: OkHttpClient.Builder,
        jsonConfigs: Json
    ): Retrofit {
        val client = clientBuilder
            .addInterceptor(CitiesAuthInterceptor())
            .build()
        return createRetrofit(client, jsonConfigs, BuildConfig.CITIES_BASE_URL)
    }

    @Provides
    @Singleton
    @RetrofitClientWeather
    fun provideWeatherRetrofitClient(
        clientBuilder: OkHttpClient.Builder,
        jsonConfigs: Json
    ): Retrofit = createRetrofit(clientBuilder.build(), jsonConfigs, "*weather url*")

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient.Builder = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .connectTimeout(TIMEOUT_CONNECTION_SECONDS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_READ_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_WRITE_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideJsonConfigurations(): Json = Json {
        isLenient = true
        ignoreUnknownKeys = true
        explicitNulls = false
        encodeDefaults = true
    }

    private fun createRetrofit(
        okHttpClient: OkHttpClient,
        json: Json,
        baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addCallAdapterFactory(FlowCallAdapterFactory.create())
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private inline fun <reified T> createApiService(retrofit: Retrofit): T {
        return retrofit.create(T::class.java)
    }

}