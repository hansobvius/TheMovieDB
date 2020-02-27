package com.example.themoviedb.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.R
import com.example.themoviedb.databinding.HomeFragmentBinding
import com.example.themoviedb.presentation.adapter.MainAdapter
import com.example.themoviedb.presentation.viewmodel.HomeViewModel
import com.example.themoviedb.remote.remotemodel.ResultModel
import kotlinx.android.synthetic.main.home_fragment.view.*
import kotlinx.android.synthetic.main.item_content.view.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: MainAdapter<ResultModel>
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = HomeFragmentBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        initObserver()
    }


    private fun initObserver(){
        viewModel.popularMovies.observe(this, Observer {value ->
            value.let {
                adapter = MainAdapter(R.layout.item_content){
                    it.initBindView {
                        it.itemView.item_text_view.text = value.results.get(0).title
                    }
                }
                binding.recyclerView.adapter = adapter
            }
        })
    }

}

