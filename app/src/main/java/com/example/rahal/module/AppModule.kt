package com.example.rahal.module

import com.example.rahal.api.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): HomeApi =
        Retrofit.Builder()
            .baseUrl("http://192.168.1.9:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HomeApi::class.java)


}