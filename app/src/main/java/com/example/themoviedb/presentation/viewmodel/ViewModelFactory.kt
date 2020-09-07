package com.example.themoviedb.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel
import com.example.themoviedb.repository.upcoming.UpComingRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val popularRepository: PopularRepository,
    private val topRatedRepository: TopRatedRepository,
    private val upComingRepository: UpComingRepository): ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(popularRepository, topRatedRepository, upComingRepository) as T
        }
        throw IllegalStateException("Unknown ViewModel Class")
    }
}