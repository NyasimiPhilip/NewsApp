package com.android.newsapp.presentation.di

import com.android.newsapp.data.repository.NewsRepositoryImpl
import com.android.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.android.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to the repository.
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    /**
     * Provides a singleton instance of NewsRepository.
     */
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}
