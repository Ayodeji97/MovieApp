package com.engie.eea_tech_interview.business.repository

import com.engie.eea_tech_interview.business.datasource.cache.cachesource.GetMoviesCacheSource
import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSource
import com.engie.eea_tech_interview.business.domain.model.Movie
import com.engie.eea_tech_interview.business.utils.Result
import com.engie.eea_tech_interview.business.utils.mapper.cachemapper.MovieCacheMapper
import com.engie.eea_tech_interview.business.utils.mapper.remotemapper.MovieDtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesRepositoryImpl @Inject constructor(
    private val getMoviesRemoteSource: GetMoviesRemoteSource,
    private val getMoviesCacheSource: GetMoviesCacheSource,
    private val movieDtoMapper: MovieDtoMapper,
    private val movieCacheMapper: MovieCacheMapper
) : GetMoviesRepository {
    override suspend fun getMovies(searchQuery: String): Flow<Result<List<Movie>>> =
        flow {
            when (val response = getMoviesRemoteSource.getMovies(searchQuery)) {
                is Result.Success -> {
                    response.data?.let {
                        val movies = movieDtoMapper.transformToEntity(it.results)
                        getMoviesCacheSource.saveMovies(movies)
                        emit(
                            Result.Success(
                                movieCacheMapper.transformToDomain(movies)
                            )
                        )
                    }
                }
                is Result.Error -> {
                    emit(Result.Error(response.errorMessage))
                }
            }
        }

    override suspend fun getMoviesFromDb(): List<Movie> {
        var movies: List<Movie> = listOf()
        getMoviesCacheSource.getMovies().collectLatest {
            movies = movieCacheMapper.transformToDomain(it)
        }
        return movies
    }
}