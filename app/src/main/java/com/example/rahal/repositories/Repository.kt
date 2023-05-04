package com.example.rahal.repositories

import android.util.Log
import com.example.rahal.api.HomeApi
import com.example.rahal.data.Place
import com.example.rahal.data.PlaceList
import com.example.rahal.database.PlaceDataBase
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val homeApi: HomeApi,
    private val placeDataBase: PlaceDataBase
) {

    private val database = placeDataBase.placeDao()
    val getFavoritesPlaces = database.getFavorites()

    suspend fun upsert(place: Place){
        database.upsert(place)
    }

    suspend fun delete(place: Place){
        database.delete(place)
    }


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