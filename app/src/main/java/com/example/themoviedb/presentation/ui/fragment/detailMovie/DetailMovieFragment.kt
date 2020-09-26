package com.example.themoviedb.presentation.ui.fragment.detailMovie

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.databinding.FragmentDetailMovieBinding
import com.example.themoviedb.presentation.ui.fragment.BaseFragment
import com.example.themoviedb.presentation.viewmodel.detailMovie.DetailMovieViewModel


class DetailMovieFragment: BaseFragment<FragmentDetailMovieBinding, DetailMovieViewModel>() {

    override fun getViewModel() = ViewModelProvider(activity!!).get(DetailMovieViewModel::class.java)

    override fun getViewBinding() = FragmentDetailMovieBinding.inflate(LayoutInflater.from(this.requireContext()))
}