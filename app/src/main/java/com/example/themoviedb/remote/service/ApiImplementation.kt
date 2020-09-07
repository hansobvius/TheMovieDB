package com.example.themoviedb.remote.service

class ApiImplementation<T>(private val serviceApi: ServiceApi, val api: Class<T>) {

    val getApi: T by lazy{ serviceApi.getApiService().create(api) }
}