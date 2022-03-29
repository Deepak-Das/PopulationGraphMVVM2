package com.example.populationgraphmvvm2.di

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.populationgraphmvvm2.data.data_source.ApiService
import com.example.populationgraphmvvm2.domain.repository.ApiServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQueue(application: Application): RequestQueue =
        Volley.newRequestQueue(application.applicationContext);

    @Provides
    @Singleton
    fun provideRepository(requestQueue: RequestQueue): ApiService =
        ApiServiceImp(requestQueue)
}