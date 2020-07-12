package com.example.themoviedb.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.themoviedb.R
import com.example.themoviedb.databinding.HomeFragmentBinding.inflate
import com.example.themoviedb.databinding.ItemContentBinding.inflate
import com.example.themoviedb.presentation.adapter.MainAdapter
import com.example.themoviedb.remote.remotemodel.ModelContract
import kotlinx.android.synthetic.main.item_content.view.*

abstract class BaseFragment<L, D, A: MainAdapter<L,D>>: Fragment() where L: ModelContract, D: ViewDataBinding {

    val view = R.layout.item_content

    abstract fun getBindingView(binding: D)

    abstract fun adapterContainer(adapter: A)
}