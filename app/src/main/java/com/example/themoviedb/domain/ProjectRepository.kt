package com.example.themoviedb.domain

import android.app.job.JobScheduler
import android.content.Context
import android.util.Log
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.remotemodel.ResultModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ProjectRepository(
    val remoteProject: RemoteProject,
    val context: Context) {

    private var scope: CoroutineScope
    private val job = SupervisorJob()

    init{
        scope = CoroutineScope(job + Dispatchers.Main)
    }

    fun initNetworkRequest(){
        scope.launch{
            remoteService()
        }
    }

    suspend fun remoteService(): ResultModel? {
        val data = remoteProject
            .fetchMovies()
            .SERVICE
            .getPopularMovies(API_KEY, LANGUAGE, PAGE)
        data.let{
            Log.i("TEST", data.body().toString())
            return data.body()
        }
    }

    companion object{
        const val API_KEY = "38eeef9aa65a725363ccb5cde9df6342"
        const val LANGUAGE = "pt"
        const val PAGE = 1
    }
}