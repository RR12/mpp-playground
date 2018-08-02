package com.khairilushan.mpp.interactor

import com.khairilushan.mpp.model.Project
import com.khairilushan.mpp.repository.ProjectRepository
import kotlinx.coroutines.experimental.Deferred
import kotlin.coroutines.experimental.CoroutineContext

class SearchProjectInteractor(
    private val repository: ProjectRepository,
    preExecutionContext: CoroutineContext,
    postExecutionContext: CoroutineContext
) : Interactor<SearchProjectInteractor.Params, List<Project>>(
    preExecutionContext, postExecutionContext
) {

    override fun build(params: Params?): Deferred<List<Project>> {
        if (params == null) throw IllegalArgumentException("params should not be null")
        return repository.searchProject(params)
    }

    class Params(val keyword: String) : RequestParams {
        override fun build(): Map<String, String> = mapOf(
            "q" to keyword
        )
    }

}
