package com.example.themoviedb.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.domain.DomainRepository
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val domainRepository: DomainRepository): ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(domainRepository) as T
        }
        throw IllegalStateException("Unknown ViewModel Class")
    }
}