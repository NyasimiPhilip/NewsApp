package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.Article
import com.android.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
       return newsRepository.getSavedNews()
    }
}