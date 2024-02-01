package com.android.newsapp.presentation.di

import com.android.newsapp.data.db.ArticleDAO
import com.android.newsapp.data.repository.datasource.NewsLocalDataSource
import com.android.newsapp.data.repository.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing local data source dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    /**
     * Provides a singleton instance of [NewsLocalDataSource].
     *
     * @param articleDAO The Data Access Object (DAO) for articles.
     * @return An instance of NewsLocalDataSource.
     */
    @Singleton
    @Provides
    fun provideLocalDataSource(articleDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDAO)
    }
}
