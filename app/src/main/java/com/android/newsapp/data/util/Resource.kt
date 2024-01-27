package com.android.newsapp.data.util

// Sealed class representing different states of a resource (SUCCESS, ERROR, LOADING)
sealed class Resource<T>(
    val data: T? = null,         // Data associated with the resource (nullable)
    val message: String? = null   // Message describing the resource state (nullable)
) {
    // Represents a successful resource state with associated data
    class SUCCESS<T>(data: T) : Resource<T>(data)

    // Represents an error resource state with associated data and an error message
    class ERROR<T>(data: T? = null, message: String) : Resource<T>(data, message)

    // Represents a loading resource state with no associated data or error message
    class LOADING<T> : Resource<T>()
}
