package com.example.themoviedb

import android.app.Application
import com.example.themoviedb.presentation.di.domainModule
import com.example.themoviedb.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoinComponent()
    }

    private fun initKoinComponent(){
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(listOf(
                presentationModule,
                domainModule
            ))
        }
    }
}