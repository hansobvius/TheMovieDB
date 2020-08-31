package com.example.themoviedb.remote.endpoint

import com.example.themoviedb.remote.service.ServiceApi

class ApiImplementation<T>(private val serviceApi: ServiceApi, val api: Class<T>?) {

    val SERVICE: T by lazy{ serviceApi.getApiService().create(api) }
}