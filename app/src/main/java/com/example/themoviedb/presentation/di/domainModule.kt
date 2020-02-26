package com.example.themoviedb.presentation.di

import com.example.themoviedb.domain.DomainRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val domainModule = module{

    single<DomainRepository>{
        DomainRepository(get(), androidContext())
    }
}