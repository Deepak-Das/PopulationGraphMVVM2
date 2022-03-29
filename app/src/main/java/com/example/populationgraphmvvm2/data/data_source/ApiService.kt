package com.example.populationgraphmvvm2.data.data_source

import com.example.populationgraphmvvm2.domain.model.Data

interface ApiService {
    fun getDataList():ArrayList<Data>
}