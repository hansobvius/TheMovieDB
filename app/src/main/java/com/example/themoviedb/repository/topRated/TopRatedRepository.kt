package com.example.themoviedb.repository.topRated

import android.util.Log
import com.example.themoviedb.repository.RepositoryImplementation
import com.example.themoviedb.presentation.model.ResultModel
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.TopRatedApi

class TopRatedRepository(
    private val remoteProject: RemoteProject<TopRatedApi>): RepositoryImplementation<ResultModel> {

    override suspend fun fetchData(callbackService: suspend () -> ResultModel?):
            ResultModel? = callbackService()

    override suspend fun remoteService(): ResultModel? = fetchData {
            remoteProject
                .fetchServiceApi()
                .getApi
                .getTopRated(API_KEY, LANGUAGE, PAGE).let{ response ->
                    return@fetchData when(response.code()){
                        200 -> {
                            Log.i("TEST", "Response: ${response.raw()}")
                            response.body()
                        }
                        else -> {
                            Log.i("TEST", "ERROR")
                            throw Exception("Error to fetch data")
                        }
                    }
                }

    }

    companion object{
        const val API_KEY = "38eeef9aa65a725363ccb5cde9df6342"
        const val LANGUAGE = "pt"
        const val PAGE = 1
    }
}