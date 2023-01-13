package com.example.weatherapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="cities")
data class CityX(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    @PrimaryKey val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)