package com.example.themoviedb.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.R
import com.example.themoviedb.databinding.HomeFragmentBinding
import com.example.themoviedb.presentation.adapter.MainAdapter
import com.example.themoviedb.presentation.viewmodel.HomeViewModel
import com.example.themoviedb.remote.remotemodel.ResultModel
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.home_fragment.view.*

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
        adapter = MainAdapter(binding.textView as View){
            it.initBindView {
                it.itemView.text_view.text = ""
            }
        }
    }

}
