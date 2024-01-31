package com.android.newsapp.presentation.di

import com.android.newsapp.domain.repository.NewsRepository
import com.android.newsapp.domain.usecase.GetNewsHeadlinesUseCase
import com.android.newsapp.domain.usecase.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun providesGetNewsHeadLinesUseCase(
        newsRepository:NewsRepository
    ): GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }
    @Provides
    @Singleton
    fun providesGetSearchedNewsUseCase(
        newsRepository:NewsRepository
    ): GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)
    }
}