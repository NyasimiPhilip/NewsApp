package com.android.newsapp.data.util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class SUCCESS<T>(data: T) : Resource<T>(data)

    class ERROR<T>(data: T? = null, val errorMessage: String) : Resource<T>(data, errorMessage)

    class LOADING<T> : Resource<T>()
}
