package com.engie.eea_tech_interview.business.repository

import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSource
import com.engie.eea_tech_interview.business.domain.model.Movie
import com.engie.eea_tech_interview.business.domain.model.SearchResult
import com.engie.eea_tech_interview.business.utils.Result
import com.engie.eea_tech_interview.business.utils.mapper.base.remotemapper.MovieDtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMoviesRepositoryImpl(
    private val getMoviesRemoteSource: GetMoviesRemoteSource,
    private val movieDtoMapper: MovieDtoMapper
) : GetMoviesRepository {
    override suspend fun getMovies(searchQuery: String): Flow<Result<List<Movie>>> =
        flow {
            when (val response = getMoviesRemoteSource.getMovies(searchQuery)) {
                is Result.Success -> {
                    response.data?.let {
                        val searchResult = movieDtoMapper.transformToEntity(it)

                    }
                }
                is Result.Error -> {
                    emit(Result.Error(response.errorMessage))
                }
            }

        }
}