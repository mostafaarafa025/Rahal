package com.example.rahal.data

data class Docuemnt(
    val _id: String,
    val activityDesctiptor: List<String>,
    val description: String,
    val id: String,
    val image: String,
    val location: Location,
    val name: String,
    val num_reviews: Int,
    val rating: Double
)