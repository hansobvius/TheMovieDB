package com.example.themoviedb.presentation.di

import com.example.themoviedb.presentation.ui.adapter.home.SectionAdapter
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.PopularApi
import com.example.themoviedb.remote.endpoint.TopRatedApi
import com.example.themoviedb.remote.endpoint.UpComingApi
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.repository.upcoming.UpComingRepository
import org.koin.dsl.module

val presentationModule = module {

    single<SectionAdapter> { SectionAdapter() }

    single<ViewModelFactory> {
        ViewModelFactory(
            PopularRepository(RemoteProject(get(), PopularApi::class.java)),
            TopRatedRepository(RemoteProject(get(), TopRatedApi::class.java)),
            UpComingRepository(RemoteProject(get(), UpComingApi::class.java))
        )
    }
}