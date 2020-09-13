package com.example.themoviedb.presentation.ui.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import com.example.themoviedb.presentation.model.ModelContract

interface IAdapter<O: ModelContract> {

    var mDiffList: AsyncListDiffer<O>?

    fun initializeAdapterData(list: List<O>)
}