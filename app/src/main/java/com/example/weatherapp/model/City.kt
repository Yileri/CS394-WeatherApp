package com.example.weatherapp.model

data class City(val name: String, val condition: String, val temp: String
, val highTemp: String, val lowTemp: String, val sunrise: String
, val sunset: String, val humidity: String, val wind: String) : java.io.Serializable
