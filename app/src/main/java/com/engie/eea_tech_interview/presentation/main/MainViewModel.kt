package com.engie.eea_tech_interview.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.engie.eea_tech_interview.business.domain.usecase.GetMoviesFromDbUseCase
import com.engie.eea_tech_interview.business.domain.usecase.GetMoviesUseCase
import com.engie.eea_tech_interview.business.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMoviesFromDbUseCase: GetMoviesFromDbUseCase
) : ViewModel() {

    private var _getSearchResultViewState = MutableStateFlow(MainViewState())
    val getSearchResultViewState = _getSearchResultViewState.asStateFlow()

    fun onTriggeredEvent(event: MainViewEvent) {
        when (event) {
            is MainViewEvent.GetSearchResult -> {
                getSearchResult(event.searchQuery)
            }
        }
    }


    private fun getSearchResult(searchQuery: String) {
        viewModelScope.launch {
            _getSearchResultViewState.value.let { state ->
                _getSearchResultViewState.value = state.copy(isLoading = false)
                getMoviesUseCase.invoke(searchQuery).collect {
                    when (it) {
                        is Result.Success -> {
                            _getSearchResultViewState.value =
                                state.copy(isLoading = false, searchResult = it.data)
                        }
                        is Result.Error -> {
                            _getSearchResultViewState.value =
                                state.copy(isLoading = false, error = it.errorMessage)
                        }
                    }
                }
            }
        }
    }
}