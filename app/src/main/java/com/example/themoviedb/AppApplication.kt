package com.example.themoviedb

import android.app.Application
import com.example.themoviedb.presentation.di.domainModule
import com.example.themoviedb.presentation.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoinComponent()
    }

    fun initKoinComponent(){
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(listOf(
                domainModule,
                remoteModule
            ))
        }
    }
}