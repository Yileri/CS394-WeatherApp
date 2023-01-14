package com.example.weatherapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="cities")
data class City(@PrimaryKey val name: String,
                @ColumnInfo(name="condition") val condition: String,
                @ColumnInfo(name="temp")val temp: String,
                @ColumnInfo(name="highTemp")val highTemp: String,
                @ColumnInfo(name="lowTemp")val lowTemp: String,
                @ColumnInfo(name="sunrise") val sunrise: String,
                @ColumnInfo(name="sunset")val sunset: String,
                @ColumnInfo(name="humidity") val humidity: String,
                @ColumnInfo(name="wind")val wind: String,
                var imageUrl: String)  : java.io.Serializable
