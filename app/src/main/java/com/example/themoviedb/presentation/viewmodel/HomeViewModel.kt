package com.example.themoviedb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.domain.DomainRepository
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.remotemodel.ResultModel
import com.example.themoviedb.remote.service.ServiceApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private var remoteProject: RemoteProject
    private var serviceApi: ServiceApi
    private var domainRepository: DomainRepository

    init{
        serviceApi = ServiceApi()
        remoteProject = RemoteProject(serviceApi)
        domainRepository = DomainRepository(remoteProject)
        initNetworkRequest()
    }

    val _poppularMovies = MutableLiveData<ResultModel>()
    val popularMovies: LiveData<ResultModel> get() = _poppularMovies

    val _mostRatedMovies = MutableLiveData<ResultModel>()
    val mostRatedMovies: LiveData<ResultModel> get() = _mostRatedMovies

    private fun initNetworkRequest(){
        viewModelScope.launch{
            _poppularMovies.value = domainRepository.remoteService()
        }
    }

    fun resetHomeViewModel(){

    }
}
