package com.engie.eea_tech_interview.business.domain.model

import com.squareup.moshi.Json

data class Movie(
    val id: Int,
    val posterPath: String?,
    val overview: String?,
    val releaseDate: String?,
    val originalTitle: String?,
    val genreIds: List<Int>?,
    val mediaType: String?,
    val originalLanguage: String?,
    val title: String?,
    val voteCount: Int?,
    val hasVideo: Boolean?,
)