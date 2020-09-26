package com.example.themoviedb.presentation.viewmodel.detailMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.presentation.model.movieDetail.MoviesDetailModel
import com.example.themoviedb.repository.movieDetail.MovieDetailRepository
import kotlinx.coroutines.launch

class DetailMovieViewModel(
    val movieDetailRepository: MovieDetailRepository): ViewModel() {

    private val _movieDetail = MutableLiveData<MoviesDetailModel>()
    val movieDetail: LiveData<MoviesDetailModel> get() = _movieDetail

    fun initDetailMovieViewModel(id: Long?){
        viewModelScope.launch {
            _movieDetail.value = movieDetailRepository.remoteService(id)
        }
    }
}