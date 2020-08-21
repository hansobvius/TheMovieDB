package com.example.themoviedb.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.databinding.HeaderContentBinding
import com.example.themoviedb.databinding.HomeFragmentBinding
import com.example.themoviedb.presentation.adapter.home.HomeAdapter
import com.example.themoviedb.presentation.adapter.home.RowAdapter
import com.example.themoviedb.presentation.adapter.home.viewholder.RowAdapterContainer
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel
import com.example.themoviedb.presentation.model.HeaderModel
import com.example.themoviedb.presentation.model.MovieModel
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    private lateinit var header: HeaderContentBinding

    private val homeAdapter: HomeAdapter by inject()
    private val rowAdapter: RowAdapter by inject()
    private val viewModelFactory: ViewModelFactory by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater).apply{
            this.lifecycleOwner = this@HomeFragment
        }
        header = HeaderContentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            activity!!, viewModelFactory).get(HomeViewModel::class.java)
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
                RecyclerView.VERTICAL,
                false)
            this.setHasFixedSize(false)
            this.adapter = rowAdapter
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
        Log.i("TEST", "list size ${model.count()}")
        rowAdapter.apply{
            this.initializeAdapterData(listOf(HeaderModel("Popular")))
            this.adapterCallback = { view, position, list ->
                Log.i("TEST", "adapterCallback list size ${list!!.count()}")
                RowAdapterContainer.createRowContainer(
                    context = this@HomeFragment.requireContext(),
                    title = list[position].title!!,
                    titleView = view.headerTitle,
                    listView = view.movieList,
                    homeAdapter = homeAdapter,
                    movieList = model.toMutableList()
                )
            }
        }
    }

}

