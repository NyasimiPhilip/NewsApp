package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.Article
import com.android.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use case responsible for retrieving saved news articles from the repository.
 *
 * @param newsRepository The repository that provides access to news-related data.
 */
class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    /**
     * Executes the use case to get a flow of saved news articles.
     *
     * @return A [Flow] emitting a list of saved [Article] objects.
     */
    fun execute(): Flow<List<Article>> {
        // Delegates the call to the corresponding method in the repository.
        return newsRepository.getSavedNews()
    }
}
