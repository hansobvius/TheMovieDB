package com.example.themoviedb.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.themoviedb.R
import com.example.themoviedb.domain.DomainRepository
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

//    val domainRepository: DomainRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart(){
        super.onStart()
//        domainRepository.initNetworkRequest()
    }

    override fun onResume(){
        super.onResume()
    }
}
