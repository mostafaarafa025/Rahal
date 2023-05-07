package com.example.rahal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place")
data class Place(
    @PrimaryKey
    val _id: String,
    val activityDesctiptor: List<String>,
    val description: String,
    //val id: String,
    val image: String,
    val location: Location,
    val name: String,
    val num_reviews: Int,
    val rating: Double
)