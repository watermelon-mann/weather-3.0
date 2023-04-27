package com.watermelonmann.data.network.interceptor

import com.watermelonmann.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CitiesAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request().newBuilder()
                .addHeader("x-api-key", BuildConfig.CITIES_API_KEY)
                .build()
        )
}