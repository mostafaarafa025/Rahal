package com.example.rahal.database

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.rahal.data.Location

@TypeConverters
class PlaceTypeConverter {

    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.split(",")
    }

    @TypeConverter
    fun listToString(list: List<String>?): String? {
        return list?.joinToString(",")
    }



}