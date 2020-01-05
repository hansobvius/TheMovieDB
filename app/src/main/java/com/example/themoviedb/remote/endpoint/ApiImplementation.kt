package com.example.themoviedb.remote.endpoint

import com.example.themoviedb.remote.service.ServiceApi

class ApiImplementation(private val serviceApi: ServiceApi) {

    val SERVICE: ApiEndpoint by lazy{
        serviceApi.getApiService().create(ApiEndpoint::class.java)
    }
}