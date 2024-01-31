package com.android.newsapp.data.util

/**
 * A sealed class representing different states of resource loading.
 *
 * @param T The type of data that the resource holds.
 * @property data The actual data of type [T]. It is nullable to represent cases where there's no data.
 * @property message A message associated with the resource, providing additional information.
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    /**
     * Represents a successful resource state with associated data.
     *
     * @property data The data associated with the successful state.
     */
    class SUCCESS<T>(data: T) : Resource<T>(data)

    /**
     * Represents an error resource state with an optional data and an error message.
     *
     * @property data The optional data associated with the error state.
     * @property errorMessage The error message describing the reason for the error.
     */
    class ERROR<T>(data: T? = null, val errorMessage: String) : Resource<T>(data, errorMessage)

    /**
     * Represents a loading resource state without associated data.
     */
    class LOADING<T> : Resource<T>()
}
