package com.example.themoviedb.presentation.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.domain.DomainRepository
import com.example.themoviedb.presentation.model.CategoryModel
import com.example.themoviedb.presentation.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val domainRepository: DomainRepository) : ViewModel() {

    init{ initNetworkRequest() }

    private val _popularMovies = MutableLiveData<CategoryModel>()
    val popularMovies: LiveData<CategoryModel> get() = _popularMovies

    private val _mostRatedMovies = MutableLiveData<ResultModel>()
    val mostRatedMovies: LiveData<ResultModel> get() = _mostRatedMovies

    private fun initNetworkRequest(){
        viewModelScope.launch(Dispatchers.Main){
            _popularMovies.value = CategoryModel("Popular", domainRepository.remoteService()!!)
        }
    }
}
