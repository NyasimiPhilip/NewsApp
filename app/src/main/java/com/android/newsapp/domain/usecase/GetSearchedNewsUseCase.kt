package com.android.newsapp.domain.usecase

import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.util.Resource
import com.android.newsapp.domain.repository.NewsRepository

/**
 * Use case responsible for retrieving searched news articles from the repository.
 *
 * @param newsRepository The repository that provides access to news-related data.
 */
class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    /**
     * Executes the use case to get searched news articles based on the provided parameters.
     *
     * @param country The country for which news articles are being searched.
     * @param searchQuery The search query used to filter news articles.
     * @param page The page number for paginated results.
     * @return A [Resource] containing the response data or an error message.
     */
    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<APIResponse> {
        // Delegates the call to the corresponding method in the repository.
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}
