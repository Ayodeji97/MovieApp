package com.engie.eea_tech_interview.business.domain.usecase

import com.engie.eea_tech_interview.business.domain.model.SearchResult
import com.engie.eea_tech_interview.business.repository.GetMoviesRepository
import com.engie.eea_tech_interview.business.utils.Result
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(
    private val getMoviesRepository: GetMoviesRepository
) {

    suspend operator fun invoke(searchQuery: String): Flow<Result<SearchResult>> =
        getMoviesRepository.getMovies(searchQuery)
}