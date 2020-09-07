package com.example.themoviedb.presentation.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.themoviedb.presentation.model.ModelContract

interface IAdapter<O: ModelContract> {

    var mDiffList: AsyncListDiffer<O>?

    fun initializeAdapterData(list: List<O>)
}