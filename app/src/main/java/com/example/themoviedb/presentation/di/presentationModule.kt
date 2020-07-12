package com.example.themoviedb.presentation.di

import com.example.themoviedb.presentation.adapter.HomeAdapter
import org.koin.dsl.module

val presentationModule = module {

    single<HomeAdapter> {
        HomeAdapter()
    }
}