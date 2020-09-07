package com.example.themoviedb.repository.upcoming

import android.util.Log
import com.example.themoviedb.presentation.model.ResultModel
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.UpComingApi
import com.example.themoviedb.repository.RepositoryImplementation

class UpComingRepository(
    private val remoteProject: RemoteProject<UpComingApi>): RepositoryImplementation<ResultModel> {

    override suspend fun fetchData(callbackService: suspend () -> ResultModel?):
            ResultModel? = callbackService()

    override suspend fun remoteService(): ResultModel? = fetchData{
        remoteProject.fetchServiceApi().getApi.getUpComing(API_KEY, LANGUAGE, PAGE).let{ response ->
                return@fetchData when(response.code()){
                    200 -> {
                        Log.i(OKHTTP_LOGGER, "Response: ${response.raw()}")
                        response.body()
                    }
                    else -> {
                        Log.i(OKHTTP_LOGGER, "ERROR")
                        throw Exception("Error to fetch data")
                    }
                }
            }
        }


    companion object{
        const val OKHTTP_LOGGER = "OkHttp"
        const val API_KEY = "38eeef9aa65a725363ccb5cde9df6342"
        const val LANGUAGE = "pt"
        const val PAGE = 1
    }
}