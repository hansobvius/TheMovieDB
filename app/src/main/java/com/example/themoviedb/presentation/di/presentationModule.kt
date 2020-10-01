package com.example.themoviedb.presentation.di

import com.example.themoviedb.presentation.ui.adapter.home.SectionAdapter
import com.example.themoviedb.presentation.ui.fragment.detailMovie.DetailPresenter
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.home.PopularApi
import com.example.themoviedb.remote.endpoint.home.TopRatedApi
import com.example.themoviedb.remote.endpoint.home.UpComingApi
import com.example.themoviedb.remote.endpoint.movieDetail.MovieDetailApi
import com.example.themoviedb.repository.movieDetail.MovieDetailRepository
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.repository.upcoming.UpComingRepository
import org.koin.dsl.module

val presentationModule = module {

    single<SectionAdapter> { SectionAdapter() }

    single<ViewModelFactory> {
        ViewModelFactory(
            PopularRepository(RemoteProject(PopularApi::class.java)),
            TopRatedRepository(RemoteProject(TopRatedApi::class.java)),
            UpComingRepository(RemoteProject(UpComingApi::class.java)),
            MovieDetailRepository(RemoteProject(MovieDetailApi::class.java))
        )
    }

    single<DetailPresenter>{ DetailPresenter() }
}