package com.engie.eea_tech_interview.di.koin.viewmodel

import com.engie.eea_tech_interview.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module{
    viewModel {
        MainViewModel(get(), get(), get())
    }
    //viewModelOf(::MainViewModel)
}