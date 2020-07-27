package com.example.themoviedb.domain

interface RepositoryImplementation<T> {

    suspend fun fetchData(callbackService: suspend () -> T?): T?
}