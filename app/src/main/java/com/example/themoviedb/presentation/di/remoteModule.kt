package com.example.themoviedb.presentation.di

import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.service.ServiceApi
import org.koin.dsl.module

val remoteModule = module {

    single<ServiceApi>{
        ServiceApi()
    }

    single<RemoteProject>{
        RemoteProject(get())
    }
}