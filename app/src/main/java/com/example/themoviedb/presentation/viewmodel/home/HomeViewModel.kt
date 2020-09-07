package com.example.themoviedb.presentation.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.presentation.model.CategoryModel
import com.example.themoviedb.repository.upcoming.UpComingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO - remove DomainRepository from ViewModel constructor
class HomeViewModel(
    private val popularRepository: PopularRepository,
    private val topRatedRepository: TopRatedRepository,
    private val upComingRepository: UpComingRepository) : ViewModel() {

    init{ initNetworkRequest() }

    private val _resultApi = MutableLiveData<List<CategoryModel>>()
    val resultApi: LiveData<List<CategoryModel>> get() = _resultApi

    private fun initNetworkRequest(){
        viewModelScope.launch(Dispatchers.Main){
            _resultApi.value = listOf(
                CategoryModel("Popular", popularRepository.remoteService()!!),
                CategoryModel("Top Rated", topRatedRepository.remoteService()!!),
                CategoryModel("Up Coming", upComingRepository.remoteService()!!)
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        _resultApi.value = null
    }
}
