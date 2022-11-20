package com.engie.eea_tech_interview.di.koin.datasource.remotesource

import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSource
import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

import org.koin.dsl.module

val RemoteSourceModule = module(createdAtStart = true) {

//    single<GetMoviesRemoteSource> {
//        GetMoviesRemoteSourceImpl(get())
//    }
    singleOf(::GetMoviesRemoteSourceImpl) {
        bind<GetMoviesRemoteSource>()
    }
}