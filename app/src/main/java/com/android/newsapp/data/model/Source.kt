package com.android.newsapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the source of a news article.
 *
 * @property id The unique identifier of the source.
 * @property name The name of the source.
 */
data class Source(
    @SerializedName("id")
    val id: String?, // Unique identifier of the source
    @SerializedName("name")
    val name: String? // Name of the source
)
