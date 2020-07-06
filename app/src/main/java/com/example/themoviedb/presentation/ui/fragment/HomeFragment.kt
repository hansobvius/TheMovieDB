package com.example.themoviedb.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.databinding.HomeFragmentBinding
import com.example.themoviedb.databinding.ItemContentBinding
import com.example.themoviedb.presentation.adapter.MainAdapter
import com.example.themoviedb.presentation.viewmodel.HomeViewModel
import com.example.themoviedb.remote.remotemodel.MovieModel
import kotlinx.android.synthetic.main.item_content.view.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var mainAdapter: MainAdapter<MovieModel, ItemContentBinding>
    private lateinit var binding: HomeFragmentBinding

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
        mainAdapter = MainAdapter(CONTENT_HOLDER)
        binding.recyclerView.apply{
            this.clipToPadding = true
            this.layoutManager = LinearLayoutManager(
                this@HomeFragment.requireContext(),
                RecyclerView.HORIZONTAL,
                false)
            this.adapter = mainAdapter
        }
    }

    private fun initObserver(){
        viewModel.popularMovies.observe(this, Observer {value ->
            value.let {
                mainAdapter.initializeAdapterData(it.results)
                mainAdapter.apply {
                    initializeAdapterData(it.results)
                    this.adapterCallback = { view, position, list -> view.itemTextView.text = list?.get(position)?.title }
                }
            }
        })
    }

    companion object{
        const val CONTENT_HOLDER = R.layout.item_content
    }
}

