package com.android.newsapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Data class representing a news article.
 *
 * @property author The author of the article.
 * @property content The content or main text of the article.
 * @property description A short description or summary of the article.
 * @property publishedAt The date and time when the article was published.
 * @property source The [Source] object containing information about the source of the article.
 * @property title The title of the article.
 * @property url The URL link to the full article.
 * @property urlToImage The URL link to the image associated with the article.
 */
data class Article(
    @SerializedName("author")
    val author: String?, // Author of the article
    @SerializedName("content")
    val content: String?, // Main text content of the article
    @SerializedName("description")
    val description: String?, // Short description or summary
    @SerializedName("publishedAt")
    val publishedAt: String?, // Date and time of publication
    @SerializedName("source")
    val source: Source?, // Information about the source of the article
    @SerializedName("title")
    val title: String?, // Title of the article
    @SerializedName("url")
    val url: String?, // URL link to the full article
    @SerializedName("urlToImage")
    val urlToImage: String? // URL link to the image associated with the article
) : Serializable
