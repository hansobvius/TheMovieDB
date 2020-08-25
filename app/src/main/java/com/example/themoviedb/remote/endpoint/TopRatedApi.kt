package com.example.themoviedb.remote.endpoint

import com.example.themoviedb.presentation.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedApi {

    @GET("top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey: String,
        @Query("language")language: String,
        @Query("page") page: Int): Response<ResultModel>
}