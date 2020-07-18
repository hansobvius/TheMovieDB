package com.example.themoviedb.domain

import android.util.Log
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.remotemodel.ResultModel

class DomainRepository(
    private val remoteProject: RemoteProject): RepositoryImplementation<ResultModel> {

    override suspend fun fetchData(callbackService: suspend () -> ResultModel?):
            ResultModel? = callbackService()

    suspend fun remoteService(): ResultModel? {
        return fetchData{
            val data = remoteProject
                .fetchPopularMovies()
                .SERVICE
                .getPopularMovies(API_KEY, LANGUAGE, PAGE)
            data.let{
                return@fetchData when(data.code()){
                    200 -> {
                        Log.i("TEST", "Response: ${data.body()}")
                        data.body()
                    }
                    else -> {
                        Log.i("TEST", "ERROR")
                        throw Exception("Error to fetch data")
                    }
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