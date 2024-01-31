package com.android.newsapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the response from the News API.
 *
 * @property articles List of [Article] objects containing news articles.
 * @property status The status of the API response.
 * @property totalResults The total number of results available from the API.
 */
data class APIResponse(
    @SerializedName("articles")
    val articles: List<Article>, // List of news articles
    @SerializedName("status")
    val status: String, // Status of the API response
    @SerializedName("totalResults")
    val totalResults: Int // Total number of results available
)
