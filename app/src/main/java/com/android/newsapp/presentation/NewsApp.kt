package com.android.newsapp.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Custom Application class for the NewsApp.
 * Annotated with [HiltAndroidApp] to enable Hilt for dependency injection.
 */
@HiltAndroidApp
class NewsApp : Application()
