package com.example.rahal

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    fun getRetrofitClientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.9:3000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}