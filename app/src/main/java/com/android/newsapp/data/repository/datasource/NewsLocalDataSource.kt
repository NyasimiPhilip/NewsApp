package com.android.newsapp.data.repository.datasource

import com.android.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Interface for local data source operations related to news articles.
 */
interface NewsLocalDataSource {

    /**
     * Saves an article to the local database.
     *
     * @param article The article to be saved.
     */
    suspend fun saveArticleToDB(article: Article)

    fun getSavedArticles(): Flow<List<Article>>
}
