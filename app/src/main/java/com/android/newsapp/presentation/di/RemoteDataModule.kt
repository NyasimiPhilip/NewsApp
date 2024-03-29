package com.android.newsapp.presentation.di

import com.android.newsapp.data.api.NewsApiService
import com.android.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.android.newsapp.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to remote data sources.
 */
@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    /**
     * Provides a singleton instance of NewsRemoteDataSource.
     */
    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(
        newsApiService: NewsApiService
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }
}
