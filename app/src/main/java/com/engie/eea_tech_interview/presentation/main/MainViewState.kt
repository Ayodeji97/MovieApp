package com.engie.eea_tech_interview.presentation.main

import com.engie.eea_tech_interview.business.domain.model.SearchResult


data class MainViewState(
    val isLoading: Boolean = false,
    val searchResult: SearchResult? = null,
    val error: String = ""
)