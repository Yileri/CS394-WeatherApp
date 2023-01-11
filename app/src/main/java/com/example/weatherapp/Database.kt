package com.example.weatherapp
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.model.City

@Database(entities = [City::class], version = 1)
abstract class Database :RoomDatabase(){

}