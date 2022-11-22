package com.engie.eea_tech_interview.di.koin.mapper

import com.engie.eea_tech_interview.business.datasource.cache.model.MovieEntity
import com.engie.eea_tech_interview.business.datasource.remote.model.MovieDto
import com.engie.eea_tech_interview.business.utils.mapper.base.BaseDtoMapper
import com.engie.eea_tech_interview.business.utils.mapper.cachemapper.MovieCacheMapper
import com.engie.eea_tech_interview.business.utils.mapper.remotemapper.MovieDtoMapper
import org.koin.dsl.module

val mapperModule = module {
    single<BaseDtoMapper<List<MovieDto>, List<MovieEntity>>> {
        MovieDtoMapper()
    }

    single { MovieCacheMapper() }
}
