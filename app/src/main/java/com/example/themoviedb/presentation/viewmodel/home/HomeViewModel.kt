package com.example.themoviedb.presentation.viewmodel.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.presentation.model.CategoryModel
import com.example.themoviedb.repository.upcoming.UpComingRepository
import kotlinx.coroutines.*
import kotlin.random.Random

class HomeViewModel(
    private val popularRepository: PopularRepository,
    private val topRatedRepository: TopRatedRepository,
    private val upComingRepository: UpComingRepository) : ViewModel() {

    private val scope: CoroutineScope by lazy{
        CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }

    private val _resultApi = MutableLiveData<List<CategoryModel>>()
    val resultApi: LiveData<List<CategoryModel>> get() = _resultApi

    private val _bannerImage = MutableLiveData<String>()
    val bannerImage: LiveData<String> get() = _bannerImage

    fun initNetworkRequest(){
        viewModelScope.launch(Dispatchers.Main){
            _resultApi.value = asyncJob().await()
            getSuggestion()
        }
    }

    private suspend fun asyncJob(): Deferred<List<CategoryModel>> = scope.async {
            val popular = async {
                popularRepository.remoteService()
            }.await()
            val topRated = async {
                topRatedRepository.remoteService()
            }.await()
            val upComing = async {
                upComingRepository.remoteService()
            }.await()
            listOf(
                CategoryModel(POPULAR_TITLE, popular!!),
                CategoryModel(TOP_RATED_TITLE, topRated!!),
                CategoryModel(UP_COMING_TITLE, upComing!!)
            )
        }

    fun cancelOperation(){
        viewModelScope.cancel()
    }

    private fun getSuggestion() {
        _bannerImage.value =
            _resultApi.value?.random()?.result?.results?.get(
                Random.nextInt(0, 19)
            )?.backdropPath
    }

    override fun onCleared() {
        super.onCleared()
        _resultApi.value = null
        _bannerImage.value = null
    }

    companion object{
        const val POPULAR_TITLE = "Popular"
        const val TOP_RATED_TITLE = "Top Rated"
        const val UP_COMING_TITLE = "Up Coming"
    }
}
