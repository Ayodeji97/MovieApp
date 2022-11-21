package com.engie.eea_tech_interview.di.koin.datasource.remotesource

import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSource
import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSourceImpl
import com.engie.eea_tech_interview.network.createOkHttpClient
import com.engie.eea_tech_interview.network.createMoshiConverter
import com.engie.eea_tech_interview.network.createMovieApiService
import com.engie.eea_tech_interview.network.createRetrofit
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