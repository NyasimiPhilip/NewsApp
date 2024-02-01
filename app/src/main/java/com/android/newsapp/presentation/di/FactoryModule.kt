package com.android.newsapp.presentation.di

import android.app.Application
import com.android.newsapp.domain.usecase.DeleteSavedNewsUseCase
import com.android.newsapp.domain.usecase.GetNewsHeadlinesUseCase
import com.android.newsapp.domain.usecase.GetSavedNewsUseCase
import com.android.newsapp.domain.usecase.GetSearchedNewsUseCase
import com.android.newsapp.domain.usecase.SaveNewsUseCase
import com.android.newsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to ViewModel factories.
 */
@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    /**
     * Provides a singleton instance of the NewsViewModelFactory.
     */
    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        )
    }
}
