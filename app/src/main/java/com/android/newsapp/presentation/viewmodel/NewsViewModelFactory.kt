package com.android.newsapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.newsapp.domain.usecase.GetNewsHeadlinesUseCase
import com.android.newsapp.domain.usecase.GetSavedNewsUseCase
import com.android.newsapp.domain.usecase.GetSearchedNewsUseCase
import com.android.newsapp.domain.usecase.SaveNewsUseCase

/**
 * Factory class responsible for creating instances of the [NewsViewModel].
 *
 * @property app The application context.
 * @property getNewsHeadlinesUseCase The use case for retrieving top headlines.
 * @property getSearchedNewsUseCase The use case for searching news.
 */
class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase
) : ViewModelProvider.Factory {

    /**
     * Creates a new instance of the [NewsViewModel] class.
     *
     * @param modelClass The class to create an instance of.
     * @return A new instance of [NewsViewModel].
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Create and return an instance of NewsViewModel with the provided dependencies
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase
        ) as T
    }
}
