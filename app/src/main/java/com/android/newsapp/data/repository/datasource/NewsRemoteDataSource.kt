package com.android.newsapp.data.repository.datasource

import com.android.newsapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines():Response<APIResponse>
}