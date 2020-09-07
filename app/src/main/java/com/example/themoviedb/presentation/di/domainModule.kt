package com.example.themoviedb.presentation.di

import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import org.koin.dsl.module

val domainModule = module{

    single<PopularRepository>{
        PopularRepository(get())
    }

    single<TopRatedRepository>{
        TopRatedRepository(get())
    }
}