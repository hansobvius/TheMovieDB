package com.example.themoviedb.remote

import com.example.themoviedb.remote.endpoint.ApiImplementation
import com.example.themoviedb.remote.service.ServiceApi

class RemoteProject(private val serviceApi: ServiceApi): RemoteImplementation {

    override fun fetchMovies(): ApiImplementation = ApiImplementation(serviceApi)
}