package com.example.themoviedb.remote

interface RemoteImplementation<out T> {

    fun fetchServiceApi(): T
}