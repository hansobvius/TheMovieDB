package com.example.themoviedb.remote.endpoint.movieDetail

import com.example.themoviedb.presentation.model.movieDetail.MoviesDetailModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailApi {

    @GET("{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Long?,
        @Query("api_key") apiKey: String,
        @Query("language")language: String): Response<MoviesDetailModel>
}