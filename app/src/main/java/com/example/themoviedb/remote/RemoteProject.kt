package com.example.themoviedb.remote

import com.example.themoviedb.remote.endpoint.ApiImplementation
import com.example.themoviedb.remote.endpoint.PopularApi
import com.example.themoviedb.remote.endpoint.TopRatedApi
import com.example.themoviedb.remote.service.ServiceApi

class RemoteProject<T>(
    private val serviceApi: ServiceApi,
    private val api: Class<T>?): RemoteImplementation<ApiImplementation<T>> {

    override fun fetchServiceApi(): ApiImplementation<T> =
        ApiImplementation(serviceApi, api)
}