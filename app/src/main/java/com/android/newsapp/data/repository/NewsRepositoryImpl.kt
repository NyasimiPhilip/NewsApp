package com.android.newsapp.data.repository

import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.model.Article
import com.android.newsapp.data.repository.datasource.NewsLocalDataSource
import com.android.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.android.newsapp.data.util.Resource
import com.android.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

/**
 * Implementation of the [NewsRepository] interface that communicates with remote data sources.
 *
 * @param newsRemoteDataSource The data source for fetching news data from the remote server.
 */
class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    /**
     * Fetches the top headlines based on the specified country and page number.
     *
     * @param country The country for which to fetch top headlines.
     * @param page The page number of the results.
     * @return A [Resource] containing the API response with a list of articles or an error message.
     */
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadLines(country, page))
    }

    /**
     * Converts a [Response] object to a [Resource] object.
     *
     * @param response The response received from the API.
     * @return A [Resource] object representing either success or failure.
     */
    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.SUCCESS(result)
            }
        }
        // If the response is not successful, return an error resource with the error message
        return Resource.ERROR(null, response.message())
    }

    /**
     * Fetches news articles based on the specified country, search query, and page number.
     *
     * @param country The country for which to fetch news articles.
     * @param searchQuery The search query used to filter news articles.
     * @param page The page number of the results.
     * @return A [Resource] containing the API response with a list of articles or an error message.
     */
    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country, searchQuery, page))
    }

    /**
     * Saves a news article to the local database.
     *
     * @param article The article to be saved.
     */
    override suspend fun saveNews(article: Article) {
       // Save the article to a local database here
        newsLocalDataSource.saveArticleToDB(article)
    }

    /**
     * Deletes a saved news article from the local database.
     *
     * @param article The article to be deleted.
     */
    override suspend fun deleteNews(article: Article) {
        // Implementation not provided, as it is marked as TODO
        // You may implement the logic to delete the article from a local database here
    }

    /**
     * Retrieves a flow of saved news articles from the local database.
     *
     * @return A [Flow] containing a list of saved news articles.
     */
    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}
