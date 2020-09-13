package com.example.themoviedb.remote

import com.example.themoviedb.remote.service.ApiImplementation
import com.example.themoviedb.remote.service.ServiceApi

class RemoteProject<T>(
    private val api: Class<T>): RemoteImplementation<ApiImplementation<T>> {

    override fun fetchServiceApi(): ApiImplementation<T> =
        ApiImplementation(api)
}