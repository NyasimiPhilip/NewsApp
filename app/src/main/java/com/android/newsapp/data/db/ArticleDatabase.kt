package com.android.newsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.newsapp.data.model.Article

/**
 * Room database class for storing articles.
 */
@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    /**
     * Provides access to the DAO (Data Access Object) for articles.
     *
     * @return The ArticleDAO instance.
     */
    abstract fun getArticleDAO(): ArticleDAO
}
