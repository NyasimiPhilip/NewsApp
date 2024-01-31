package com.android.newsapp.data.repository.datasourceimpl

import com.android.newsapp.data.api.NewsApiService
import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newApiService: NewsApiService,

) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {

        return newApiService.getTopHeadlines(country, page)

    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newApiService.getSearchedNews(country, searchQuery, page)
    }
}
