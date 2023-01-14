package com.example.weatherapp.retrofit

import com.example.weatherapp.model.CityX
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("data/2.5/weather?q=London&units=metric&appid=8a777b83cc0a5a5dbb7c2498423eed2d")
    fun getLondon(): Call<CityX>

    @GET("data/2.5/weather?q=Paris&units=metric&appid=8a777b83cc0a5a5dbb7c2498423eed2d")
    fun getParis():Call<CityX>

    @GET("data/2.5/weather?q=Istanbul&units=metric&appid=8a777b83cc0a5a5dbb7c2498423eed2d")
    fun getIstanbul():Call<CityX>

    @GET("data/2.5/weather?q=Ankara&units=metric&appid=8a777b83cc0a5a5dbb7c2498423eed2d")
    fun getAnkara():Call<CityX>

    @GET("data/2.5/weather?q=Izmır&units=metric&appid=8a777b83cc0a5a5dbb7c2498423eed2d")
    fun getIzmir():Call<CityX>
}