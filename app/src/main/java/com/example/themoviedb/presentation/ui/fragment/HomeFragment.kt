package com.example.themoviedb.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.databinding.HomeFragmentBinding
import com.example.themoviedb.presentation.adapter.HomeAdapter
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.presentation.viewmodel.HomeViewModel
import com.example.themoviedb.remote.remotemodel.MovieModel
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    private val homeAdapter: HomeAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater).apply{
            this.lifecycleOwner = this@HomeFragment
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        this@HomeFragment.run{
            this.initAdapter()
            this.initObserver()
        }
    }

    private fun initAdapter(){
        binding.recyclerView.apply{
            this.clipToPadding = true
            this.layoutManager = LinearLayoutManager(
                this@HomeFragment.requireContext(),
                RecyclerView.HORIZONTAL,
                false)
            this.adapter = homeAdapter
        }
    }

    private fun initObserver(){
        viewModel.popularMovies.observe(this, Observer {value ->
            value?.let {
               createRowAdapter(it.results)
            }
        })
    }

    private fun createRowAdapter(model: List<MovieModel>){
        homeAdapter.apply {
            this.initializeAdapterData(model)
            this.adapterCallback = { view, position, list ->
                createPosterCard(position, list!!, view.itemImageView)
            }
        }
    }

    private fun createPosterCard(position: Int, list: MutableList<MovieModel>, view: ImageView){
        ImageHelper.render(
            this@HomeFragment.requireContext(),
            list.get(position).posterPath,
            view
        )
    }
}

