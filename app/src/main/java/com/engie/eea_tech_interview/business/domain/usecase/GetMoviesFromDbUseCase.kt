package com.engie.eea_tech_interview.business.domain.usecase

import com.engie.eea_tech_interview.business.domain.model.Movie
import com.engie.eea_tech_interview.business.repository.GetMoviesRepository
import javax.inject.Inject

class GetMoviesFromDbUseCase @Inject constructor(
    private val getMoviesRepository: GetMoviesRepository
) {
    suspend operator fun invoke(): List<Movie> =
        getMoviesRepository.getMoviesFromDb()

}