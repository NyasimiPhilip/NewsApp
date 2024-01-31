package com.android.newsapp.data.repository.datasource

import com.android.newsapp.data.model.APIResponse
import retrofit2.Response

/**
 * Interface defining methods to interact with the remote data source for news-related information.
 */
interface NewsRemoteDataSource {

    /**
     * Retrieves the top headlines based on the specified country and page number.
     *
     * @param country The country for which to retrieve top headlines.
     * @param page The page number of the results.
     * @return A [Response] containing the API response with a list of articles.
     */
    suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse>

    /**
     * Retrieves searched news based on the specified country, search query, and page number.
     *
     * @param country The country for which to retrieve searched news.
     * @param searchQuery The search query to filter news articles.
     * @param page The page number of the results.
     * @return A [Response] containing the API response with a list of articles matching the search query.
     */
    suspend fun getSearchedNews(country: String, searchQuery: String, page: Int): Response<APIResponse>
}
