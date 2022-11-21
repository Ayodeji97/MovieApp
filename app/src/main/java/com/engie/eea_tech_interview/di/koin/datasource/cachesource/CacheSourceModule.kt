package com.engie.eea_tech_interview.di.koin.datasource.cachesource

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cacheSourceModule = module(createdAtStart = true) {

    single { provideMovieDatabase(androidApplication()) }

    single { provideMovieDao(get()) }
}