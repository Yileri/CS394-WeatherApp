package com.example.weatherapp.data

import android.content.Context
import com.example.weatherapp.R
import com.example.weatherapp.model.City

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

    fun loadCities(): List<City> {
        val nameList = getCitysName()
        val conditionList = getCitysCondition()
        val tempList = getCitysTemp()
        val highTempList = getCitysHighTemp()
        val lowTempList = getCitysLowTemp()
        val sunriseList = getCitysSunrise()
        val sunsetList = getCitysSunset()
        val humidityList = getCitysHumidity()
        val windList = getCitysWind()

        var cities = mutableListOf<City>()

        val city = City(nameList[0], conditionList[0], tempList[0],
        highTempList[0], lowTempList[0], sunriseList[0], sunsetList[0],
        humidityList[0], windList[0])

        cities.add(city)

        return cities
    }
}