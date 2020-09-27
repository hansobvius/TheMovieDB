package com.example.themoviedb.repository.popular

import android.util.Log
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.repository.RepositoryImplementation
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.presentation.model.home.ResultModel
import com.example.themoviedb.remote.endpoint.home.PopularApi

class PopularRepository(
    private val remoteProject: RemoteProject<PopularApi>): RepositoryImplementation<ResultModel> {

    override suspend fun fetchData(callbackService: suspend () -> ResultModel?):
            ResultModel? = callbackService()

    override suspend fun remoteService(id: Long?): ResultModel? = fetchData{
        remoteProject.fetchServiceApi().getApi.getPopularMovies(BuildConfig.API_KEY, LANGUAGE, PAGE).let{ response ->
            Log.i(OKHTTP_LOGGER, "${response.raw()}")
            return@fetchData when(response.code()){
                200 -> response.body()
                else -> null
            }
        }
    }

    companion object{
        const val OKHTTP_LOGGER = "OkHttp"
        const val LANGUAGE = "pt"
        const val PAGE = 1
    }
}