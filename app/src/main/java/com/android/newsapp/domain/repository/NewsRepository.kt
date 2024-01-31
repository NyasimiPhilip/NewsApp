package com.android.newsapp.domain.repository

import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.model.Article
import com.android.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for handling news-related data operations.
 */
interface NewsRepository {
    /**
     * Fetches news headlines based on the specified country and page.
     *
     * @param country The country for which news headlines are requested.
     * @param page The page number of news headlines to fetch.
     * @return A [Resource] containing the result of the operation.
     */
    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>

    /**
     * Searches for news based on the specified country, search query, and page.
     *
     * @param country The country for which news is searched.
     * @param searchQuery The query used for news search.
     * @param page The page number of the search results to fetch.
     * @return A [Resource] containing the result of the operation.
     */
    suspend fun getSearchedNews(country: String, searchQuery: String, page: Int): Resource<APIResponse>

    /**
     * Saves a news article to the repository.
     *
     * @param article The article to be saved.
     */
    suspend fun saveNews(article: Article)

    /**
     * Deletes a news article from the repository.
     *
     * @param article The article to be deleted.
     */
    suspend fun deleteNews(article: Article)

    /**
     * Retrieves a flow of saved news articles.
     *
     * @return A [Flow] emitting a list of saved news articles.
     */
    fun getSavedNews(): Flow<List<Article>>
}
