package com.android.newsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.newsapp.data.model.Article
import com.android.newsapp.databinding.NewsListItemBinding
import com.bumptech.glide.Glide

/**
 * Adapter for the RecyclerView displaying news articles.
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    // Callback for calculating the difference between two non-null items in a list.
    private val callback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            // Check if the items have the same URL, considering them the same.
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            // Check if the contents of the items are the same.
            return oldItem == newItem
        }
    }

    // AsyncListDiffer to efficiently compute the differences between two lists on a background thread.
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        // Inflate the layout for the list item and create a ViewHolder.
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        // Return the size of the current list.
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        // Bind data to the ViewHolder at the specified position.
        val article = differ.currentList[position]
        holder.bind(article)
    }

    /**
     * ViewHolder class representing each item in the RecyclerView.
     */
    inner class NewsViewHolder(val binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Bind data to the ViewHolder.
         */
        fun bind(article: Article) {
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description
            binding.tvPublishedAt.text = article.publishedAt
            binding.tvSource.text = article.source?.name

            // Load the image using Glide library.
            Glide.with(binding.ivArticleImage.context)
                .load(article.urlToImage)
                .into(binding.ivArticleImage)

            // Set click listener for the item.
            binding.root.setOnClickListener {
                // Invoke the item click listener if set.
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }

    // Listener for item click events.
    private var onItemClickListener: ((Article) -> Unit)? = null

    /**
     * Set the item click listener for the adapter.
     */
    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}
