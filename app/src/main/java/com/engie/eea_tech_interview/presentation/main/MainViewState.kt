package com.engie.eea_tech_interview.presentation.main

import android.app.appsearch.SearchResult

data class MainViewState(
    val isLoading: Boolean = false,
    val searchResult: SearchResult? = null,
    val error: String = ""
)