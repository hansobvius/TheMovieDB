package com.example.themoviedb.presentation.di

import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.LatestApi
import com.example.themoviedb.remote.endpoint.PopularApi
import com.example.themoviedb.remote.endpoint.TopRatedApi
import com.example.themoviedb.remote.endpoint.UpComingApi
import com.example.themoviedb.remote.service.ServiceApi
import org.koin.dsl.module

val remoteModule = module {

    single<ServiceApi>{
        ServiceApi()
    }

    // TODO - generic type needed / cannot create multiple instances from same class
//    factory<RemoteProject<PopularApi>>{
//        RemoteProject(get(), PopularApi::class.java)
//    }
//
//    factory<RemoteProject<LatestApi>>{
//        RemoteProject(get(), LatestApi::class.java)
//    }
//
//    factory<RemoteProject<TopRatedApi>>{
//        RemoteProject(get(), TopRatedApi::class.java)
//    }
//
//    factory<RemoteProject<UpComingApi>>{
//        RemoteProject(get(), UpComingApi::class.java)
//    }
}