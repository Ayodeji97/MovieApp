package com.engie.eea_tech_interview.di.koin.datasource.cachesource

import android.app.Application
import androidx.room.Room
import com.engie.eea_tech_interview.business.datasource.cache.MovieDatabase
import com.engie.eea_tech_interview.business.datasource.cache.dao.MovieDao
import com.engie.eea_tech_interview.business.utils.Constants.DATABASE_NAME

fun provideMovieDatabase(app: Application): MovieDatabase =
    Room
        .databaseBuilder(app, MovieDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration() // get correct db version if schema changed
        .build()

fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao =
    movieDatabase.movieDao()