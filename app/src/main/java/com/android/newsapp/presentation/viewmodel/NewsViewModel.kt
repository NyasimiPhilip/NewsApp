package com.android.newsapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.newsapp.data.model.APIResponse
import com.android.newsapp.data.util.Resource
import com.android.newsapp.domain.usecase.GetNewsHeadlinesUseCase
import com.android.newsapp.domain.usecase.GetSearchedNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * ViewModel for managing and providing data related to news headlines.
 *
 * @property app The application context.
 * @property getNewsHeadlinesUseCase The use case for retrieving top headlines.
 * @property getSearchedNewsUseCase The use case for searching news.
 */
class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase
) : AndroidViewModel(app) {

    // LiveData for top headlines
    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    /**
     * Retrieves top headlines and updates the [newsHeadLines] LiveData.
     *
     * @param country The country for which headlines are requested.
     * @param page The page number of headlines to retrieve.
     */
    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        // Post LOADING state to LiveData
        newsHeadLines.postValue(Resource.LOADING())

        try {
            // Check if the network is available
            if (isNetworkAvailable(app)) {
                // Call the use case to get news headlines
                val apiResult = getNewsHeadlinesUseCase.execute(country, page)

                // Post the result to LiveData
                newsHeadLines.postValue(apiResult)
            } else {
                // Network is not available, post ERROR state to LiveData
                newsHeadLines.postValue(Resource.ERROR(null, "No network available"))
            }
        } catch (e: Exception) {
            // Catch specific exception types if necessary
            newsHeadLines.postValue(Resource.ERROR(null, e.message.toString()))
        }
    }

    /**
     * Checks if the network is available.
     *
     * @param context The context to use for checking network availability.
     * @return True if the network is available; false otherwise.
     */
    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false

        // Get the ConnectivityManager service
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // For Android M and above, use the NetworkCapabilities to check the internet connection
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

            return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            // For versions below Android M, use the deprecated methods
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo?.isConnected == true
        }
    }

    // LiveData for searched news
    val searchedNews: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    /**
     * Searches for news and updates the [searchedNews] LiveData.
     *
     * @param country The country for which news is searched.
     * @param searchQuery The query string for news search.
     * @param page The page number of search results to retrieve.
     */
    fun searchNews(
        country: String,
        searchQuery: String,
        page: Int
    ) = viewModelScope.launch {
        // Post LOADING state to LiveData
        searchedNews.postValue(Resource.LOADING())

        try {
            // Check if the network is available
            if (isNetworkAvailable(app)) {
                // Call the use case to search for news
                val response = getSearchedNewsUseCase.execute(
                    country,
                    searchQuery,
                    page
                )
                searchedNews.postValue(response)
            } else {
                // Network is not available, post ERROR state to LiveData
                searchedNews.postValue(Resource.ERROR(null, "No internet connection"))
            }
        } catch (e: Exception) {
            // Catch specific exception types if necessary
            searchedNews.postValue(Resource.ERROR(null, e.message.toString()))
        }
    }
}
