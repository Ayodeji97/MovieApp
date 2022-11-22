package com.engie.eea_tech_interview

import androidx.multidex.MultiDexApplication
import com.engie.eea_tech_interview.di.koin.datasource.cachesource.cacheSourceModule
import com.engie.eea_tech_interview.di.koin.datasource.remotesource.networkModule
import com.engie.eea_tech_interview.di.koin.datasource.remotesource.remoteSourceModule
import com.engie.eea_tech_interview.di.koin.mapper.mapperModule
import com.engie.eea_tech_interview.di.koin.parentModule
import com.engie.eea_tech_interview.di.koin.repository.repositoryModule
import com.engie.eea_tech_interview.di.koin.usecase.useCaseModule
import com.engie.eea_tech_interview.di.koin.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

//open class BaseApplication: MultiDexApplication() {
//
//    override fun onCreate() {
//        super.onCreate()
//
//        startKoin {
//            androidContext(this@BaseApplication)
//           modules(getDependencyModules())
//            //modules(parentModule)
//        }
//    }
//
//    open fun getDependencyModules(): List<Module> {
//        return listOf(
//            networkModule,
//            cacheSourceModule,
//            remoteSourceModule,
//            repositoryModule,
//            mapperModule,
//            useCaseModule,
//            viewModelModule
//        )
//    }
//}
