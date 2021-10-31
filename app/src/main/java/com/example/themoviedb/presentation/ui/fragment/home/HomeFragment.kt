package com.example.themoviedb.presentation.ui.fragment.home

import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.R
import com.example.themoviedb.databinding.FragmentHomeBinding
import com.example.themoviedb.presentation.ui.adapter.home.SectionAdapter
import com.example.themoviedb.presentation.ui.adapter.home.viewholder.SectionAdapterContainer
import com.example.themoviedb.presentation.model.movies.CategoryModel
import com.example.themoviedb.presentation.ui.fragment.BaseFragment
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel
import org.koin.java.KoinJavaComponent.inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val sectionAdapter: SectionAdapter by inject(SectionAdapter::class.java)
    private val viewModelFactory: ViewModelFactory by inject(ViewModelFactory::class.java)

    override fun getViewModel() = ViewModelProvider(this.requireActivity(), viewModelFactory)[HomeViewModel::class.java]

    override fun getViewBinding() = FragmentHomeBinding.inflate(LayoutInflater.from(this.requireContext()))

    override fun onStart(){
        super.onStart()
        viewModel.initNetworkRequest()
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
            resultApi.observe(this@HomeFragment, { value ->
                value?.let {
                    createRowAdapter(it)
                }
            })
            bannerLiveData.observe(this@HomeFragment, { imageBanner ->
                imageBanner?.let{ bannerModel ->
                    binding.bannerView.apply{
                        ImageHelper.render(this@HomeFragment.requireContext(), bannerModel.posterPath, this)
                        this.setOnClickListener {
                            navigateTo(this@HomeFragment, R.id.action_homeFragment_to_movieDetailFragment, bannerModel.bannerId)
                        }
                    }
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
                    title = model[position].category,
                    titleView = view.headerTitle,
                    listView = view.movieList,
                    movieList = list!![position].result.results
                ){ id ->
                    navigateTo(this@HomeFragment, R.id.action_homeFragment_to_movieDetailFragment, id)
                }
            }
        }
    }
}

