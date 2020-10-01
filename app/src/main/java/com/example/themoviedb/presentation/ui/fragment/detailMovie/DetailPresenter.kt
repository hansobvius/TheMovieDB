package com.example.themoviedb.presentation.ui.fragment.detailMovie

import com.example.themoviedb.databinding.FragmentDetailMovieBinding
import com.example.themoviedb.presentation.model.movieDetail.MoviesDetailModel
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.presentation.viewmodel.detailMovie.DetailMovieViewModel

class DetailPresenter() {

    fun init(binding: FragmentDetailMovieBinding?, viewModel: DetailMovieViewModel, model: MoviesDetailModel){
        buildDetailView(binding, model)
    }

    private fun buildDetailView(binding: FragmentDetailMovieBinding?, model: MoviesDetailModel){
        binding?.let{ view ->
            ImageHelper.render(view.root.context, model.backdropPath, view.detailBannerImage)
            view.movieTitle.text = model.title
            view.textDescription.text = model.overview
        }
    }

    private fun buildCommentsView(){

    }
}