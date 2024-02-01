package com.android.newsapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.android.newsapp.data.db.ArticleDAO
import com.android.newsapp.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing database-related dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    /**
     * Provides a singleton instance of [ArticleDatabase].
     *
     * @param app The application context.
     * @return An instance of the ArticleDatabase.
     */
    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): ArticleDatabase {
        return Room.databaseBuilder(app, ArticleDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Provides a singleton instance of [ArticleDAO].
     *
     * @param articleDatabase The ArticleDatabase instance.
     * @return An instance of the ArticleDAO.
     */
    @Singleton
    @Provides
    fun provideNewsDao(articleDatabase: ArticleDatabase): ArticleDAO {
        return articleDatabase.getArticleDAO()
    }
}
