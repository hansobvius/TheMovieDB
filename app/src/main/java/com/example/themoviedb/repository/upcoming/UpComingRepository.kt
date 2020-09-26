package com.example.themoviedb.repository.upcoming

import android.util.Log
import com.example.themoviedb.BuildConfig
import com.example.themoviedb.presentation.model.home.ResultModel
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.home.UpComingApi
import com.example.themoviedb.repository.RepositoryImplementation

class UpComingRepository(
    private val remoteProject: RemoteProject<UpComingApi>): RepositoryImplementation<ResultModel> {

    override suspend fun fetchData(callbackService: suspend () -> ResultModel?):
            ResultModel? = callbackService()

    override suspend fun remoteService(): ResultModel? = fetchData{
        remoteProject.fetchServiceApi().getApi.getUpComing(BuildConfig.API_KEY, LANGUAGE, PAGE).let{ response ->
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