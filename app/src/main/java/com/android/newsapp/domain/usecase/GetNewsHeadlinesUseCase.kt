package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.util.Resource
import com.android.newsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines()
    }
}