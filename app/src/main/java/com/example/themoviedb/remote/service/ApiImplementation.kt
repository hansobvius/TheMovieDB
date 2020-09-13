package com.example.themoviedb.remote.service

class ApiImplementation<T>(private val api: Class<T>) {

    val getApi: T by lazy{ ServiceApi.getApiService().create(api) }
}