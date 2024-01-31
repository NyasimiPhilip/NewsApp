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


class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase
): AndroidViewModel(app){

    val newsHeadLines : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.LOADING())

        // Check if the network is available
        try {
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
            newsHeadLines.postValue(Resource.ERROR( null, e.message.toString()))
        }
    }
    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false

        // Get the ConnectivityManager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // For Android M and above, use the NetworkCapabilities to check the internet connection
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

            return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            // For versions below Android M, use the deprecated methods
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo?.isConnected == true
        }
    }

    //search
    val searchedNews: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun searchNews(
        country: String,
        searchQuery: String,
        page: Int
    ) = viewModelScope.launch{
        searchedNews.postValue(Resource.LOADING())
        try{
        if(isNetworkAvailable(app)){
            val response = getSearchedNewsUseCase.execute(
                country,
                searchQuery,
                page
            )
            searchedNews.postValue(response)

        }else{
            searchedNews.postValue(Resource.ERROR(null, "no internet connection"))
        }}catch (e: Exception){
            searchedNews.postValue(Resource.ERROR(null, e.message.toString()))
        }
    }
}