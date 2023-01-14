package com.example.weatherapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.model.CityX

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   fun addCity(city:CityX)

    @Query("SELECT * FROM cities")
    fun getAll(): List<CityX>

}