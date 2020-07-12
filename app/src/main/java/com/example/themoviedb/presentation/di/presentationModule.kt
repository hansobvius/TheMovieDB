package com.example.themoviedb.presentation.di

import com.example.themoviedb.presentation.adapter.home.HomeAdapter
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import org.koin.dsl.module

val presentationModule = module {

    single<HomeAdapter> {
        HomeAdapter()
    }

    single<ViewModelFactory> {
        ViewModelFactory(get())
    }
}