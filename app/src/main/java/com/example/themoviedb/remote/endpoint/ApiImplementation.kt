package com.example.themoviedb.remote.endpoint

import com.example.themoviedb.remote.service.ServiceApi

class ApiImplementation(private val serviceApi: ServiceApi) {

    val SERVICE: PopularApi by lazy{
        serviceApi.getApiService().create(PopularApi::class.java)
    }
}