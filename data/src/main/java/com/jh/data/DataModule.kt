package com.jh.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jh.data.api.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val BASE_URL = BuildConfig.SERVER_URL
    private const val API_TIMEOUT = 5000L
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(API_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideUserService(client: OkHttpClient): UserService {
        return createRetrofit(client).create(UserService::class.java)
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun createRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            client(client)
            baseUrl(BASE_URL)
            addConverterFactory(json.asConverterFactory(MediaType.parse("application/json")!!))
        }.build()
    }

}