package com.example.themoviedb.remote

import com.example.themoviedb.remote.endpoint.ApiImplementation
import com.example.themoviedb.remote.service.ServiceApi

class RemoteProject(private val serviceApi: ServiceApi): RemoteImplementation {

    override fun fetchPopularMovies(): ApiImplementation = ApiImplementation(serviceApi)

    override fun fetchMostRatedMovies(): ApiImplementation = ApiImplementation(serviceApi)
}