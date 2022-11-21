package com.engie.eea_tech_interview.di.koin.mapper

import com.engie.eea_tech_interview.business.utils.mapper.base.remotemapper.MovieDtoMapper
import org.koin.dsl.module

val mapperModule = module {
    single { MovieDtoMapper() }
}