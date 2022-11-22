package com.engie.eea_tech_interview.business.repository

import com.engie.eea_tech_interview.business.datasource.cache.model.MovieEntity
import com.engie.eea_tech_interview.business.domain.model.Movie
import com.engie.eea_tech_interview.business.utils.Result
import kotlinx.coroutines.flow.Flow

interface GetMoviesRepository {
    suspend fun getMovies(searchQuery: String): Flow<Result<List<Movie>>>
    suspend fun getMoviesFromDb(): Flow<List<MovieEntity>>
}
