package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.util.Resource
import com.android.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String,searchQuery: String,page: Int): Resource<APIResponse>{
       return newsRepository.getSearchedNews( country, searchQuery, page)
    }
}