package com.engie.eea_tech_interview.business.repository

import com.engie.eea_tech_interview.business.domain.model.SearchResult
import com.engie.eea_tech_interview.business.utils.Result
import kotlinx.coroutines.flow.Flow

interface GetMoviesRepository {
    suspend fun getMovies(searchQuery : String) : Flow<Result<SearchResult>>
}