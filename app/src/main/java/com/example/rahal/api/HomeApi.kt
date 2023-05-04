package com.example.rahal.api

import com.example.rahal.data.Data
import com.example.rahal.data.PlaceList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("attractions")
    suspend fun getAttractions(
        @Query("sort") sort: String
    ): Response<PlaceList>
}