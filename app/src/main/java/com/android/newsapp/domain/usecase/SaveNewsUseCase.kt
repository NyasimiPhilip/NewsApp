package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.Article
import com.android.newsapp.domain.repository.NewsRepository

/**
 * Use case responsible for saving news articles to the repository.
 *
 * @param newsRepository The repository that provides access to news-related data.
 */
class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    /**
     * Executes the use case to save a news article.
     *
     * @param article The news article to be saved.
     */
    suspend fun execute(article: Article) {
        // Delegates the call to the corresponding method in the repository.
        newsRepository.saveNews(article)
    }
}
