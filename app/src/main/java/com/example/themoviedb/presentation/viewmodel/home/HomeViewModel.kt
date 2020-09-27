package com.example.themoviedb.presentation.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.presentation.model.home.BannerModel
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.presentation.model.home.CategoryModel
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

    private val _bannerLiveData = MutableLiveData<BannerModel>()
    val bannerLiveData: LiveData<BannerModel> get() = _bannerLiveData

    fun initNetworkRequest(){
        viewModelScope.launch(Dispatchers.Main){
            _resultApi.value = asyncJob().await()
            getSuggestion()
        }
    }

    private suspend fun asyncJob(): Deferred<MutableList<CategoryModel>?> = scope.async {
            val categoryModel: MutableList<CategoryModel>? = mutableListOf()
            async {
                popularRepository.remoteService(null)
            }.await()?.let {
                categoryModel?.add(CategoryModel(POPULAR_TITLE, it))
            }
            async {
                topRatedRepository.remoteService(null)
            }.await()?.let{
                categoryModel?.add(CategoryModel(TOP_RATED_TITLE, it))
            }
            async {
                upComingRepository.remoteService(null)
            }.await()?.let {
                categoryModel?.add(CategoryModel(UP_COMING_TITLE, it))
            }
            categoryModel
        }

    fun cancelOperation(){
        viewModelScope.cancel()
    }

    private fun getSuggestion() {
        _resultApi.value?.random()?.result?.results?.get(
            Random.nextInt(0, 19)
        )?.apply {
            val banner = BannerModel(this.id, this.backdropPath)
            _bannerLiveData.value = banner
        }
    }

    override fun onCleared() {
        super.onCleared()
        _resultApi.value = null
        _bannerLiveData.value = null
    }

    companion object{
        const val POPULAR_TITLE = "Popular"
        const val TOP_RATED_TITLE = "Top Rated"
        const val UP_COMING_TITLE = "Up Coming"
    }
}
