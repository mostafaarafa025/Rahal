package com.example.rahal.repositories

import android.util.Log
import com.example.rahal.api.HomeApi
import com.example.rahal.data.Data
import com.example.rahal.data.Docuemnt
import com.example.rahal.data.PlaceList
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val homeApi: HomeApi
) {

    suspend fun getRecommended(sort: String): Response<PlaceList>{
        val response = homeApi.getAttractions(sort)
        if (response.isSuccessful){
            Log.d("TestApp","Success to connect getAttractions() repo: ${response.code()}")
        }else {
            Log.d("TestApp","Failed to connected getAttractions(): ${response.code()}")
        }
        return response
    }

    suspend fun getTopRated(sort: String): Response<PlaceList>{
        val response = homeApi.getAttractions(sort)
        if (response.isSuccessful){
            Log.d("TestApp","Success to connect getAttractions() repo: ${response.code()}")
        }else {
            Log.d("TestApp","Failed to connected getAttractions(): ${response.code()}")
        }
        return response
    }

}