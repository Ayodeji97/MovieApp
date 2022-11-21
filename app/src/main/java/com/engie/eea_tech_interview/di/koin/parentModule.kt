package com.engie.eea_tech_interview.di.koin

import com.engie.eea_tech_interview.di.koin.datasource.remotesource.networkModule
import com.engie.eea_tech_interview.di.koin.datasource.remotesource.remoteSourceModule
import com.engie.eea_tech_interview.di.koin.mapper.mapperModule
import com.engie.eea_tech_interview.di.koin.repository.repositoryModule
import com.engie.eea_tech_interview.di.koin.viewmodel.viewModelModule
import org.koin.dsl.module

val parentModule = module{
    includes(
        networkModule,
        remoteSourceModule,
        mapperModule,
        repositoryModule,
        viewModelModule
    )
}