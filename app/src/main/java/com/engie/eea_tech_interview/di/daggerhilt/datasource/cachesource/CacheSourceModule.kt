package com.engie.eea_tech_interview.di.daggerhilt.datasource.cachesource

import android.app.Application
import androidx.room.Room
import com.engie.eea_tech_interview.business.datasource.cache.MovieDatabase
import com.engie.eea_tech_interview.business.datasource.cache.cachesource.GetMoviesCacheSource
import com.engie.eea_tech_interview.business.datasource.cache.dao.MovieDao
import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSource
import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSourceImpl
import com.engie.eea_tech_interview.business.utils.Constants.DATABASE_NAME
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheSourceModule {

    @Singleton
    @Provides
    fun provideAppDb(app: Application): MovieDatabase =
        Room
            .databaseBuilder(app, MovieDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()


    @Singleton
    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao =
        movieDatabase.movieDao()

}