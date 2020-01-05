package com.example.themoviedb.remote

import com.example.themoviedb.remote.endpoint.ApiImplementation

interface RemoteImplementation {

    fun fetchMovies(): ApiImplementation
}