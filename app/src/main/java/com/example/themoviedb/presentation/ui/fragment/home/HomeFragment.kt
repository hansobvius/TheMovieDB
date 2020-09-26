package com.example.themoviedb.presentation.ui.fragment.home

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.databinding.FragmentHomeBinding
import com.example.themoviedb.presentation.ui.adapter.home.SectionAdapter
import com.example.themoviedb.presentation.ui.adapter.home.viewholder.SectionAdapterContainer
import com.example.themoviedb.presentation.model.home.CategoryModel
import com.example.themoviedb.presentation.ui.fragment.BaseFragment
import com.example.themoviedb.presentation.util.ImageHelper
import com.example.themoviedb.presentation.viewmodel.ViewModelFactory
import com.example.themoviedb.presentation.viewmodel.home.HomeViewModel
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val sectionAdapter: SectionAdapter by inject()
    private val viewModelFactory: ViewModelFactory by inject()

    override fun getViewModel() = ViewModelProvider(this.requireActivity(), viewModelFactory).get(HomeViewModel::class.java)

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

