package com.engie.eea_tech_interview.business.utils.mapper.base.remotemapper


import com.engie.eea_tech_interview.business.datasource.remote.model.SearchResultDto
import com.engie.eea_tech_interview.business.domain.model.SearchResult
import com.engie.eea_tech_interview.business.utils.mapper.base.BaseDtoMapper
// You will need to change this later on

class MovieDtoMapper : BaseDtoMapper<SearchResultDto, SearchResult>{
    override fun transformToEntity(type: SearchResultDto): SearchResult =
        SearchResult(
            results = type.results
        )
}