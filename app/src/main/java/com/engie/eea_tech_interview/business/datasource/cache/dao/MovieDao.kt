package com.engie.eea_tech_interview.business.datasource.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.engie.eea_tech_interview.business.datasource.cache.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): Flow<List<MovieEntity>>
}
