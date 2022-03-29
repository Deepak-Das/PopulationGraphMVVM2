package com.example.populationgraphmvvm2.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.populationgraphmvvm2.data.data_source.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository : ApiService
    ) : ViewModel() {

    init {
        Log.i("List", "getDataList: ${repository.getDataList().toString()}")

    }
}