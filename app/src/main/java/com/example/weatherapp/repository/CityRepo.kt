
package com.example.weatherapp.repository

import com.example.weatherapp.model.CityX
import com.example.weatherapp.retrofit.ApiInterface
import com.example.weatherapp.room.OurDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CityRepo (
    private val cityDB:OurDatabase
    ){

fun  AddTheCities(){
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api:ApiInterface=retrofit.create(ApiInterface::class.java)

    val London =api.getLondon()
    val Paris =api.getParis()
    val Istanbul =api.getIstanbul()
    val Ankara =api.getAnkara()
    val Izmir =api.getIzmir()

    cityDB.cityDao().addCity(London)
    cityDB.cityDao().addCity(Paris)
    cityDB.cityDao().addCity(Istanbul)
    cityDB.cityDao().addCity(Ankara)
    cityDB.cityDao().addCity(Izmir)
}
     fun getCities():List<CityX>{

        val cities :List<CityX>
       cities=cityDB.cityDao().getAll();

        return cities
    }
}
