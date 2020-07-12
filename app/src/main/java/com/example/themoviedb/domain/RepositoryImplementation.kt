package com.example.themoviedb.domain

import com.example.themoviedb.remote.remotemodel.ResultModel

interface RepositoryImplementation<T> {

    suspend fun fetchData(callbackService: suspend () -> T?): T?
}