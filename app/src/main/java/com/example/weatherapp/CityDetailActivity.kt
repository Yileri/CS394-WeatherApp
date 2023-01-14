package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.weatherapp.databinding.FragmentCityDetailBinding

import com.example.weatherapp.model.CityX

class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        val binding : FragmentCityDetailBinding = DataBindingUtil.setContentView(this,R.layout.fragment_city_detail)
        val selectedCity = intent.getSerializableExtra("CITYX") as CityX
        binding.city = selectedCity
    }
}