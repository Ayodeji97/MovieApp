package com.engie.eea_tech_interview.business.domain.model

import com.engie.eea_tech_interview.business.datasource.remote.model.MovieDto


data class SearchResult(
    val results: List<MovieDto>
)