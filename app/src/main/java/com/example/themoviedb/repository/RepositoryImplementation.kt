package com.example.themoviedb.repository

interface RepositoryImplementation<T> {

    suspend fun fetchData(callbackService: suspend () -> T?): T?

    suspend fun remoteService(id: Long?): T?{
        return null
    }
}