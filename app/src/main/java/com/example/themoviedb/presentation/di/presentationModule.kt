package com.example.themoviedb.presentation.di

import com.example.themoviedb.presentation.adapter.home.RowAdapter
import com.example.themoviedb.presentation.adapter.home.SectionAdapter
import org.koin.dsl.module

val presentationModule = module {

    single<RowAdapter> { RowAdapter() }

    single<SectionAdapter> { SectionAdapter() }

//    single<ViewModelFactory> { ViewModelFactory(get(), get()) }
}