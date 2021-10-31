package com.example.themoviedb.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.presentation.viewmodel.detailMovie.DetailMovieViewModel
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel
import com.example.themoviedb.repository.movieDetail.MovieDetailRepository
import com.example.themoviedb.repository.upComing.UpComingRepository
import com.example.themoviedb.repository.userReview.UserReviewRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val popularRepository: PopularRepository,
    private val topRatedRepository: TopRatedRepository,
    private val upComingRepository: UpComingRepository,
    private val movieDetailRepository: MovieDetailRepository,
    private val userReviewRepository: UserReviewRepository): ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
            HomeViewModel(popularRepository, topRatedRepository, upComingRepository) as T
        }
        modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
            DetailMovieViewModel(movieDetailRepository, userReviewRepository) as T
        }
        else -> throw IllegalStateException("Unknown ViewModel Class")
    }
}