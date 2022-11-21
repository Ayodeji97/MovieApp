package com.engie.eea_tech_interview.di.koin.mapper

import com.engie.eea_tech_interview.business.utils.mapper.cachemapper.MovieCacheMapper
import com.engie.eea_tech_interview.business.utils.mapper.remotemapper.MovieDtoMapper
import org.koin.dsl.module

val mapperModule = module {
    single { MovieDtoMapper() }
    single { MovieCacheMapper() }
}