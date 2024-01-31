package com.android.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.android.newsapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var fragmentInfoBinding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Using View Binding to access views in a type-safe manner
        fragmentInfoBinding = FragmentInfoBinding.bind(view)

        // Accessing arguments using the navigation component's safe args
        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedArticle

        // Setting up WebView to display the article's URL
        fragmentInfoBinding.wvInfo.apply {
            webViewClient = WebViewClient()

            // Check if the article's URL is not empty before loading
            if (article.url != null && article.url.isNotEmpty()) {
                loadUrl(article.url)
            } else {
                // Display a toast message for an invalid URL
                Toast.makeText(context, "Invalid URL", Toast.LENGTH_LONG).show()
            }
        }
    }
}
