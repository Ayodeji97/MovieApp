package com.engie.eea_tech_interview.di.koin.usecase

import com.engie.eea_tech_interview.business.domain.usecase.GetMoviesFromDbUseCase
import com.engie.eea_tech_interview.business.domain.usecase.GetMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetMoviesUseCase(get()) }
    single { GetMoviesFromDbUseCase(get()) }
}
