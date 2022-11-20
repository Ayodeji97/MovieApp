package com.engie.eea_tech_interview.business.domain.model

import com.engie.eea_tech_interview.business.datasource.remote.model.GenreDto


data class GenreResult(
    val genre: List<GenreDto>
)
