package com.example.themoviedb.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlin.reflect.KClass

abstract class BaseFragment<B, V>: Fragment() where B: ViewDataBinding, V: ViewModel {

    internal lateinit var viewModel: V

    internal lateinit var binding: B

    abstract fun getViewModel(): V

    abstract fun getViewBinding(): B

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding().apply {
            this.lifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel()
    }

    companion object{

        const val ID_PATH = "ID_ARGUMENT_KEY"

        fun navigateTo(fragment: Fragment, navigationId: Int, argsId: Long?){
            val bundle = Bundle()
            argsId?.let{
                bundle.putLong(ID_PATH, it)
            }
            fragment.findNavController().navigate(navigationId, bundle)
        }
    }
}