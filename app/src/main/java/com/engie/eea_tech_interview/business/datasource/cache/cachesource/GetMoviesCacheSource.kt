package com.engie.eea_tech_interview.business.datasource.cache.cachesource

import androidx.room.Dao
import com.engie.eea_tech_interview.business.datasource.cache.dao.MovieDao
import com.engie.eea_tech_interview.business.datasource.cache.model.MovieEntity
import kotlinx.coroutines.flow.Flow

class GetMoviesCacheSource(
    private val movieDao: MovieDao
) {
    suspend fun saveMovies(movies: List<MovieEntity>) =
        movieDao.insert(movies)

    suspend fun getMovies(): Flow<List<MovieEntity>> =
        movieDao.getMovies()
}