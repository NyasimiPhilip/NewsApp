package com.android.newsapp.data.repository.datasourceimpl

import com.android.newsapp.data.db.ArticleDAO
import com.android.newsapp.data.model.Article
import com.android.newsapp.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

/**
 * Implementation of [NewsLocalDataSource] for local data source operations related to news articles.
 *
 * @param articleDAO The Data Access Object (DAO) for articles.
 */
class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
) : NewsLocalDataSource {

    /**
     * Saves an article to the local database using the provided [ArticleDAO].
     *
     * @param article The article to be saved.
     */
    override suspend fun saveArticleToDB(article: Article) {
        // Calling the insert method of the ArticleDAO to save the article to the local database
        articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDAO.deleteArticle(article)
    }
}
