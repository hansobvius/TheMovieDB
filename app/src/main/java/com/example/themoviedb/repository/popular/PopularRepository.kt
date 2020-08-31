package com.example.themoviedb.repository.popular

import android.util.Log
import com.example.themoviedb.repository.RepositoryImplementation
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.presentation.model.ResultModel
import com.example.themoviedb.remote.endpoint.PopularApi

// TODO - declare a generic type to pass api endpoint
class PopularRepository(
    private val remoteProject: RemoteProject<PopularApi>): RepositoryImplementation<ResultModel> {

    override suspend fun fetchData(callbackService: suspend () -> ResultModel?):
            ResultModel? = callbackService()

    // TODO - remove function to properly get particular api interface function
    override suspend fun remoteService(): ResultModel? {
        return fetchData{
            val data = remoteProject
                .fetchServiceApi()
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