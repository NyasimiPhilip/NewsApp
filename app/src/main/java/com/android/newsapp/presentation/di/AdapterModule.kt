package com.android.newsapp.presentation.di

import com.android.newsapp.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to adapters.
 */
@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    /**
     * Provides a singleton instance of the NewsAdapter.
     */
    @Singleton
    @Provides
    fun provideNewsAdapter(): NewsAdapter {
        return NewsAdapter()
    }
}
