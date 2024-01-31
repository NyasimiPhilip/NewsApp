package com.android.newsapp.data.repository.datasourceimpl

import com.android.newsapp.data.api.NewsApiService
import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

/**
 * Implementation of [NewsRemoteDataSource] that interacts with the News API service.
 *
 * @param newApiService The [NewsApiService] used to make API requests.
 */
class NewsRemoteDataSourceImpl(
    private val newApiService: NewsApiService
) : NewsRemoteDataSource {

    /**
     * Retrieves the top headlines based on the specified country and page number.
     *
     * @param country The country for which to retrieve top headlines.
     * @param page The page number of the results.
     * @return A [Response] containing the API response with a list of articles.
     */
    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        // Delegate the call to the News API service's getTopHeadlines method
        return newApiService.getTopHeadlines(country, page)
    }

    /**
     * Retrieves searched news based on the specified country, search query, and page number.
     *
     * @param country The country for which to retrieve searched news.
     * @param searchQuery The search query to filter news articles.
     * @param page The page number of the results.
     * @return A [Response] containing the API response with a list of articles matching the search query.
     */
    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        // Delegate the call to the News API service's getSearchedNews method
        return newApiService.getSearchedNews(country, searchQuery, page)
    }
}
