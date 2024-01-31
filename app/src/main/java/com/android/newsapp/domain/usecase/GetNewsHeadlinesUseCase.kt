package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.util.Resource
import com.android.newsapp.domain.repository.NewsRepository

/**
 * Use case responsible for retrieving news headlines.
 *
 * @property newsRepository The repository for news-related data operations.
 */
class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    /**
     * Executes the use case to get news headlines.
     *
     * @param country The country for which news headlines are requested.
     * @param page The page number of news headlines to retrieve.
     * @return A [Resource] containing the result of the operation.
     */
    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}
