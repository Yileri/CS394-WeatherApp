package com.example.weatherapp.retrofit

import com.example.weatherapp.model.CityX
import retrofit2.http.GET


interface ApiInterface {
    @GET("data/2.5/weather?q=London&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1")
    fun getLondon(): CityX

    @GET("data/2.5/weather?q=Paris&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1")
    fun getParis():CityX

    @GET("data/2.5/weather?q=Istanbul&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1")
    fun getIstanbul():CityX

    @GET("data/2.5/weather?q=Ankara&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1")
    fun getAnkara():CityX

    @GET("data/2.5/weather?q=Izmır&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1")
    fun getIzmir():CityX
}