package com.android.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.android.newsapp.databinding.ActivityMainBinding
import com.android.newsapp.presentation.adapter.NewsAdapter
import com.android.newsapp.presentation.viewmodel.NewsViewModel
import com.android.newsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter
    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // Obtain the NavController from the FragmentContainerView
        navController = navHostFragment.navController

        // Set up BottomNavigationView with NavController
        binding.bnvNews.setupWithNavController(navController)

        viewModel = ViewModelProvider(this, factory)
            .get(NewsViewModel::class.java)

    }
}
