package com.example.themoviedb.remote.endpoint.movieDetail

import com.example.themoviedb.presentation.model.movieDetail.MoviesDetailModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailApi {

    @GET("movies")
    suspend fun getMovieDetails(
        @Query("api_key") apiKey: String,
        @Query("language")language: String): Response<MoviesDetailModel>
}