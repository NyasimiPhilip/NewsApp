package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.Article
import com.android.newsapp.domain.repository.NewsRepository

/**
 * Use case responsible for deleting saved news articles.
 *
 * @property newsRepository The repository for news-related data operations.
 */
class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    /**
     * Executes the use case to delete a saved news article.
     *
     * @param article The news article to be deleted.
     */
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}
