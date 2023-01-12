
package com.example.weatherapp.Retrofit

import com.example.weatherapp.model.CityX
import retrofit2.http.GET

val CityExample:String="London"// burda hangi şehirleri çekizec yazmak yapmak lazım

val BASE_URL:String="https://api.openweathermap.org/data/2.5/weather?q=London&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1"// çekeceğimiz adress bve benim sebaımla girdiğim API key

interface ApiInterface {
    @GET("data/2.5/weather?q=London&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1")
    fun getLondon():CityX
}
