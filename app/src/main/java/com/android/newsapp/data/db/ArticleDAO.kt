package com.android.newsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for the Article entity.
 */
@Dao
interface ArticleDAO {

    /**
     * Inserts an article into the database.
     *
     * @param article The article to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<Article>>
}
