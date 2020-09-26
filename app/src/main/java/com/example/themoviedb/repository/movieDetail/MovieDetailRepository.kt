package com.example.themoviedb.repository.movieDetail

import android.util.Log
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.presentation.model.movieDetail.MoviesDetailModel
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.movieDetail.MovieDetailApi
import com.example.themoviedb.repository.RepositoryImplementation

class MovieDetailRepository(
    private val remoteProject: RemoteProject<MovieDetailApi>): RepositoryImplementation<MoviesDetailModel> {

    override suspend fun fetchData(callbackService: suspend () -> MoviesDetailModel?):
            MoviesDetailModel? = callbackService()

    override suspend fun remoteService(): MoviesDetailModel? = fetchData{
        remoteProject.fetchServiceApi().getApi.getMovieDetails(BuildConfig.API_KEY, LANGUAGE).let{ response ->
            Log.i(OKHTTP_LOGGER, "${response.raw()}")
            return@fetchData when(response.code()){
                200 -> response.body()
                else -> throw Exception("Error to fetch data ${this::class.java.name}")
            }
        }
    }

    companion object{
        const val OKHTTP_LOGGER = "OkHttp"
        const val LANGUAGE = "pt"
        const val PAGE = 1
    }
}