package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.Article
import com.android.newsapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}