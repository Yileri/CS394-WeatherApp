package com.example.weatherapp.data

import android.content.Context
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R

import com.example.weatherapp.model.CityX
import com.example.weatherapp.repository.CityRepo
import com.example.weatherapp.room.OurDatabase

class DataSource(val context: Context) {
    fun getCitysName(): Array<String> {
        return context.resources.getStringArray(R.array.name_array)
    }

    fun getCitysCondition(): Array<String> {
        return context.resources.getStringArray(R.array.condition_array)
    }

    fun getCitysTemp(): Array<String> {
        return context.resources.getStringArray(R.array.temp_array)
    }

    fun getCitysHighTemp(): Array<String> {
        return context.resources.getStringArray(R.array.hightemp_array)
    }

    fun getCitysLowTemp(): Array<String> {
        return context.resources.getStringArray(R.array.lowtemp_array)
    }

    fun getCitysSunrise(): Array<String> {
        return context.resources.getStringArray(R.array.sunrise_array)
    }

    fun getCitysSunset(): Array<String> {
        return context.resources.getStringArray(R.array.sunset_array)
    }

    fun getCitysHumidity(): Array<String> {
        return context.resources.getStringArray(R.array.humidity_array)
    }

    fun getCitysWind(): Array<String> {
        return context.resources.getStringArray(R.array.wind_array)
    }

    fun getCitysImageUrl(): Array<String> {
        return context.resources.getStringArray(R.array.image_url)
    }

   /*
    fun loadCities(): List<CityX> {
        val nameList = getCitysName()
        val conditionList = getCitysCondition()
        val tempList = getCitysTemp()
        val highTempList = getCitysHighTemp()
        val lowTempList = getCitysLowTemp()
        val sunriseList = getCitysSunrise()
        val sunsetList = getCitysSunset()
        val humidityList = getCitysHumidity()
        val windList = getCitysWind()
        val imageUrlList = getCitysImageUrl()

        var cities = mutableListOf<CityX>()

        for (i in 0..2) {
            val city = CityX(
                nameList[i],
                conditionList[i],
                tempList[i],
                highTempList[i],
                lowTempList[i],
                sunriseList[i],
                sunsetList[i],
                humidityList[i],
                windList[i],
                imageUrlList[i]
            )
            cities.add(city)
        }

        return cities
    }

*/
}