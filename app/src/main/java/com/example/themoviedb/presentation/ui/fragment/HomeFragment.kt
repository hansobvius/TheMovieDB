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
import com.example.themoviedb.presentation.ui.adapter.home.SectionAdapter
import com.example.themoviedb.presentation.ui.adapter.home.viewholder.SectionAdapterContainer
import com.example.themoviedb.presentation.model.CategoryModel
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    private lateinit var header: HeaderContentBinding

    private val sectionAdapter: SectionAdapter by inject()
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
            activity!!, viewModelFactory).get(HomeViewModel::class.java
        ).also { viewModel ->
            viewModel.initNetworkRequest()
        }
    }

    override fun onResume() {
        super.onResume()
        this@HomeFragment.run{
            this.initAdapter()
            this.initObserver()
        }
    }

    override fun onPause(){
        super.onPause()
        viewModel.cancelOperation()
    }

    override fun onDestroy(){
        super.onDestroy()
        viewModel.resultApi.removeObservers(this@HomeFragment)
    }

    private fun initAdapter(){
        binding.recyclerView.apply{
            this.setHasFixedSize(false)
            this.adapter = sectionAdapter
        }
    }

    private fun initObserver(){
        viewModel.apply{
            resultApi.observe(this@HomeFragment, Observer { value ->
                value?.let {
                    createRowAdapter(it)
                }
            })
            bannerImage.observe(this@HomeFragment, Observer { imageBanner ->
                imageBanner?.let{
                    ImageHelper.render(this@HomeFragment.requireContext(), it, binding.bannerView)
                }
            })
        }
    }

    private fun createRowAdapter(model: List<CategoryModel>){
        sectionAdapter.apply{
            this.initializeAdapterData(model)
            this.adapterCallback = { view, position, list ->
                SectionAdapterContainer.createRowContainer(
                    context = this@HomeFragment.requireContext(),
                    title = model.get(position).category,
                    titleView = view.headerTitle,
                    listView = view.movieList,
                    movieList = list!!.get(position).result.results
                ){
                    Toast.makeText(this@HomeFragment.requireContext(), "position: ${it + 1}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}

