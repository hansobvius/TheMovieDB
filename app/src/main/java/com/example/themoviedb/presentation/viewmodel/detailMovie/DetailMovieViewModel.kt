package com.example.themoviedb.presentation.viewmodel.detailMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.presentation.model.movieDetail.MoviesDetailModel
import com.example.themoviedb.presentation.model.userReviews.ReviewResult
import com.example.themoviedb.presentation.model.userReviews.UserResults
import com.example.themoviedb.repository.movieDetail.MovieDetailRepository
import com.example.themoviedb.repository.userReview.UserReviewRepository
import kotlinx.coroutines.launch

class DetailMovieViewModel(
    private val movieDetailRepository: MovieDetailRepository,
    private val userReviewRepository: UserReviewRepository): ViewModel() {

    private val _movieDetail = MutableLiveData<MoviesDetailModel>()
    val movieDetail: LiveData<MoviesDetailModel> get() = _movieDetail

    private val _resultReview = MutableLiveData<ReviewResult>()
    val resultReview: LiveData<ReviewResult> get() =  _resultReview

    fun initDetailMovieViewModel(id: Long?){
        viewModelScope.launch {
            _movieDetail.value = movieDetailRepository.remoteService(id)
            _resultReview.value = userReviewRepository.remoteService(id)
        }
    }

    fun cleanMovieValue(){
        _movieDetail.value = null
    }
}