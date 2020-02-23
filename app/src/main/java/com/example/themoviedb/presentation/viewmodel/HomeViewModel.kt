package com.example.themoviedb.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb.remote.remotemodel.ResultModel

class HomeViewModel : ViewModel() {

    val _poppularMovies = MutableLiveData<ResultModel>()

    val _mostRatedMovies = MutableLiveData<ResultModel>()


}
