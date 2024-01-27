package com.android.newsapp.data.repository.datasourceimpl

import com.android.newsapp.data.api.NewsApiService
import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newApiService: NewsApiService,
    private val country: String,
    private val page: Int,

) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(): Response<APIResponse> {

        return newApiService.getTopHeadlines(country, page)

    }
}
