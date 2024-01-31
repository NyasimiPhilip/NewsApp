package com.android.newsapp.data.api

import com.android.newsapp.BuildConfig
import com.android.newsapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface for defining News API endpoints.
 */
interface NewsApiService {

    /**
     * Retrieves the top headlines from the News API.
     *
     * @param country The country for which headlines are requested.
     * @param page The page number of results to fetch.
     * @param apiKey The API key used for authentication. Defaults to the value from BuildConfig.
     * @return A [Response] containing [APIResponse] with the top headlines.
     */
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>

    /**
     * Searches for news articles using a query string.
     *
     * @param country The country for which headlines are requested.
     * @param searchQuery The search query used to filter news articles.
     * @param page The page number of results to fetch.
     * @param apiKey The API key used for authentication. Defaults to the value from BuildConfig.
     * @return A [Response] containing [APIResponse] with the searched news articles.
     */
    @GET("/v2/top-headlines")
    suspend fun getSearchedNews(
        @Query("country") country: String,
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>
}
