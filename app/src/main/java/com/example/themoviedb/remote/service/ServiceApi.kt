package com.example.themoviedb.remote.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceApi {

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    }

    fun getApiService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}