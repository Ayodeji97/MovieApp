package com.engie.eea_tech_interview.business.utils.mapper.cachemapper

import com.engie.eea_tech_interview.business.datasource.cache.model.MovieEntity
import com.engie.eea_tech_interview.business.domain.model.Movie
import com.engie.eea_tech_interview.business.utils.mapper.base.BaseEntityMapper

class MovieCacheMapper : BaseEntityMapper<List<MovieEntity>, List<Movie>> {
    override fun transformToDomain(type: List<MovieEntity>): List<Movie> =
        type.map { movieEntity ->
            Movie(
                posterPath = movieEntity.posterPath,
                overview = movieEntity.overview,
                releaseDate = movieEntity.releaseDate,
                originalLanguage = movieEntity.originalLanguage,
                mediaType = movieEntity.mediaType,
                originalTitle = movieEntity.originalTitle,
                title = movieEntity.title,
                voteCount = movieEntity.voteCount
            )
        }
}