package com.engie.eea_tech_interview.di.koin.datasource.remotesource

import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSource
import com.engie.eea_tech_interview.business.datasource.remote.remotesource.GetMoviesRemoteSourceImpl
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.named
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named

import org.koin.dsl.module

val remoteSourceModule = module {


    single(named("IODispatcher")) {
        Dispatchers.IO
    }

    single<GetMoviesRemoteSource> {
        GetMoviesRemoteSourceImpl(get(), get(named("IODispatcher")))
    }

//    singleOf(::GetMoviesRemoteSourceImpl) {
//        bind<GetMoviesRemoteSource>()
//    }

}