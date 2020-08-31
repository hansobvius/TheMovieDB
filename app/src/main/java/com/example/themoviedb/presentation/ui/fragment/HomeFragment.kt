package com.example.themoviedb.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.databinding.HeaderContentBinding
import com.example.themoviedb.databinding.HomeFragmentBinding
import com.example.themoviedb.repository.popular.PopularRepository
import com.example.themoviedb.repository.topRated.TopRatedRepository
import com.example.themoviedb.presentation.adapter.home.HomeAdapter
import com.example.themoviedb.presentation.adapter.home.RowAdapter
import com.example.themoviedb.presentation.adapter.home.viewholder.RowAdapterContainer
import com.example.themoviedb.presentation.model.CategoryModel
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel
import com.example.themoviedb.remote.RemoteProject
import com.example.themoviedb.remote.endpoint.PopularApi
import com.example.themoviedb.remote.endpoint.TopRatedApi
import com.example.themoviedb.remote.service.ServiceApi
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    private lateinit var header: HeaderContentBinding
    private lateinit var viewModelFactory: ViewModelFactory

    private val homeAdapter: HomeAdapter by inject()
    private val rowAdapter: RowAdapter by inject()
//    private val viewModelFactory: ViewModelFactory by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater).apply{
            this.lifecycleOwner = this@HomeFragment
        }
        header = HeaderContentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelFactory = ViewModelFactory(
            PopularRepository(RemoteProject(ServiceApi(), PopularApi::class.java)),
            TopRatedRepository(RemoteProject(ServiceApi(), TopRatedApi::class.java))
        )
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
        viewModel.resultApi.observe(this, Observer { value ->
            value?.let {
               createRowAdapter(it)
            }
        })
    }

    private fun createRowAdapter(model: List<CategoryModel>){
        Log.i("TEST", "row popular ${model.get(0).result.results.get(0).title} / row rateded ${model.get(1).result.results.get(1).title}")
        rowAdapter.apply{
            this.initializeAdapterData(model)
            this.adapterCallback = { view, position, list ->
                RowAdapterContainer.createRowContainer(
                    context = this@HomeFragment.requireContext(),
                    title = model.get(position).category,
                    titleView = view.headerTitle,
                    listView = view.movieList,
                    homeAdapter = homeAdapter,
                    movieList = list?.get(position)?.result?.results?.toMutableList()
                ){
                    Toast.makeText(this@HomeFragment.requireContext(), "position: ${it + 1}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}

