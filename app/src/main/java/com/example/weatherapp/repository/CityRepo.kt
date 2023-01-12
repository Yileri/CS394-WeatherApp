/*
package com.example.weatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.model.CityX
import com.example.weatherapp.retrofit.ApiInterface
import com.example.weatherapp.room.OurDatabase

class CityRepo (
    private val cityDB:OurDatabase,
    private val apiInterface:ApiInterface
    ){

private val citiesLiveData:MutableLiveData<CityX>()


    val şehirler:LiveData<CityX>

        get()=citiesLiveData

suspend fun  getAll(){
    val result=apiInterface.getLondon()

    if(result.body()!= null){

        cityDB.cityDao().addCity(result)

    }
}
}
*/
