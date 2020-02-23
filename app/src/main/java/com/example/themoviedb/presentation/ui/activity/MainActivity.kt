package com.example.themoviedb.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.themoviedb.R
import com.example.themoviedb.domain.ProjectRepository
import com.example.themoviedb.remote.remotemodel.ResultModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val projectRepository: ProjectRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart(){
        super.onStart()
        projectRepository.initNetworkRequest()
    }

    override fun onResume(){
        super.onResume()

    }
}
