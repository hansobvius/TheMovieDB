package com.example.themoviedb.presentation.adapter

import com.example.themoviedb.presentation.model.ModelContract

interface IAdapter<O: ModelContract> {

    var objectList: MutableList<O>?
}