package com.engie.eea_tech_interview.di.koin.datasource.remotesource


import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module(createdAtStart = true) {
    single {
        val baseUrl = "https://api.themoviedb.org/3/"
        createRetrofit(baseUrl, get(), get())
    }

    single { createOkHttpClient(androidContext()) }

    single { createMoshiConverter() }

    single { createMovieApiService(get()) }

}