package com.engie.eea_tech_interview.di.koin.repository

import com.engie.eea_tech_interview.business.repository.GetMoviesRepository
import com.engie.eea_tech_interview.business.repository.GetMoviesRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::GetMoviesRepositoryImpl) {
        bind<GetMoviesRepository>()
    }
}
