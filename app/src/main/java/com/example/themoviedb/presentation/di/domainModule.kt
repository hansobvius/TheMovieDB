package com.example.themoviedb.presentation.di

import com.example.themoviedb.domain.ProjectRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val domainModule = module{

    single<ProjectRepository>{
        ProjectRepository(get(), androidContext())
    }
}