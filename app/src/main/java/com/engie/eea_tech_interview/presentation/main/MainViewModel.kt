package com.engie.eea_tech_interview.presentation.main

import androidx.lifecycle.ViewModel
import com.engie.eea_tech_interview.business.domain.usecase.GetMoviesUseCase

class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {


}