package com.example.weatherapp

import androidx.room.Dao
import androidx.room.Query
import com.example.weatherapp.model.City

@Dao
interface CityDao {
    @Query("SELECT* FROM cities")
    fun getAll():List<City>

}