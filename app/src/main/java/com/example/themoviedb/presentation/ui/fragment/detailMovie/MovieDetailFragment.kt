package com.example.themoviedb.presentation.ui.fragment.detailMovie

import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.databinding.FragmentDetailMovieBinding
import com.example.themoviedb.presentation.model.movieDetail.MoviesDetailModel
import com.example.themoviedb.presentation.ui.fragment.BaseFragment
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.presentation.viewmodel.detailMovie.DetailMovieViewModel
import org.koin.java.KoinJavaComponent.inject

class MovieDetailFragment: BaseFragment<FragmentDetailMovieBinding, DetailMovieViewModel>() {

    private val viewModelFactory: ViewModelFactory by inject(ViewModelFactory::class.java)

    private val detailPresenter: DetailPresenter by inject(DetailPresenter::class.java)

    override fun getViewModel() = ViewModelProvider(requireActivity(), viewModelFactory).get(DetailMovieViewModel::class.java)

    override fun getViewBinding() = FragmentDetailMovieBinding.inflate(LayoutInflater.from(this.requireContext()))

    override fun onStart(){
        super.onStart()
        val argumentId: Long? = arguments?.getLong(ID_PATH)
        viewModel.apply{
            this.initDetailMovieViewModel(argumentId)
        }
    }

    override fun onResume(){
        super.onResume()
        this@MovieDetailFragment.apply{
            initObservers()
        }
    }

    override fun onStop(){
        super.onStop()
        viewModel.cleanMovieValue()
    }

    private fun initObservers(){
        viewModel.movieDetail.observe(viewLifecycleOwner, Observer {
            it?.let{
                detailPresenter.init(
                    binding = binding,
                    viewModel = viewModel,
                    model = it
                )
            }
        })
    }
}