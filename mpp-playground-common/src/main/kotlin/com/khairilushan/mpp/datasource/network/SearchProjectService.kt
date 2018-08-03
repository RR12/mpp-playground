package com.khairilushan.mpp.datasource.network

import com.khairilushan.mpp.datasource.network.entity.SearchProjectsEntity
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTreeParser

class SearchProjectService : NetworkService<SearchProjectsEntity>() {
    override val path = "/search/repositories"

    override fun parse(json: String): SearchProjectsEntity {
        val element = JsonTreeParser(json).readFully()
        return (element as JsonObject).run { SearchProjectsEntity.create(this) }
    }
}
