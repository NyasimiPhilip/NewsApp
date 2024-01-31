package com.android.newsapp.presentation.di

import com.android.newsapp.BuildConfig
import com.android.newsapp.data.api.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to network operations.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    /**
     * Provides a singleton instance of Retrofit with GsonConverterFactory for JSON parsing.
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    /**
     * Provides a singleton instance of the NewsApiService using the provided Retrofit instance.
     */
    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }
}
