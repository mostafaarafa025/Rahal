package com.example.rahal.data.search

import com.example.rahal.data.Location

data class City(
    val __v: Int,
    val _id: String,
    val activityDesctiptor: List<String>,
    val cuisine: List<String>,
    val description: String,
    val hotelClass: Double,
    val image: String,
    val location: Location,
    val name: String,
    val numberOfReviews: Int,
    val phone: String,
    val priceLevel: String,
    val rating: Double,
    val type: String
)