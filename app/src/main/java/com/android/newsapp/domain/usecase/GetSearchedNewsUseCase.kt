package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.util.Resource
import com.android.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse>{
       return newsRepository.getSearchedNews(searchQuery)
    }
}