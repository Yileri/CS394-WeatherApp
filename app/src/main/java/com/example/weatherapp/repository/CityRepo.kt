
package com.example.weatherapp.repository

import android.content.Context
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R
import com.example.weatherapp.model.CityX
import com.example.weatherapp.retrofit.ApiInterface
import com.example.weatherapp.room.OurDatabase
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CityRepo(
    val context: Context,
    private val cityDB:OurDatabase
    ){

 fun  AddTheCities(){
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api:ApiInterface=retrofit.create(ApiInterface::class.java)

    api.getIstanbul().enqueue(object : Callback<CityX> {
        override fun onResponse(call: Call<CityX>, response: Response<CityX>) {
            if (response.isSuccessful) {
                val city = response.body()
                if (city != null) {
                    cityDB.cityDao().addCity(city)
                }
            }
        }

        override fun onFailure(call: Call<CityX>, t: Throwable) {
            // Handle error
        }
    })
    api.getAnkara().enqueue(object : Callback<CityX> {
        override fun onResponse(call: Call<CityX>, response: Response<CityX>) {
            if (response.isSuccessful) {
                val city = response.body()
                if (city != null) {
                    cityDB.cityDao().addCity(city)
                }
            }
        }

        override fun onFailure(call: Call<CityX>, t: Throwable) {
            // Handle error
        }
    })

    api.getIzmir().enqueue(object : Callback<CityX> {
        override fun onResponse(call: Call<CityX>, response: Response<CityX>) {
            if (response.isSuccessful) {
                val city = response.body()
                if (city != null) {
                    cityDB.cityDao().addCity(city)
                }
            }
        }

        override fun onFailure(call: Call<CityX>, t: Throwable) {
            // Handle error
        }
    })
    api.getLondon().enqueue(object : Callback<CityX> {
        override fun onResponse(call: Call<CityX>, response: Response<CityX>) {
            if (response.isSuccessful) {
                val city = response.body()
                if (city != null) {
                    cityDB.cityDao().addCity(city)
                }
            }
        }

        override fun onFailure(call: Call<CityX>, t: Throwable) {
            // Handle error
        }
    })
    api.getParis().enqueue(object : Callback<CityX> {
        override fun onResponse(call: Call<CityX>, response: Response<CityX>) {
            if (response.isSuccessful) {
                val city = response.body()
                if (city != null) {
                    cityDB.cityDao().addCity(city)
                }
            }
        }

        override fun onFailure(call: Call<CityX>, t: Throwable) {
            // Handle error
        }
    })


}
    fun getCitysImageUrl(): Array<String> {
        return context.resources.getStringArray(R.array.image_url)
    }
     fun getCities():List<CityX>{
        var image = getCitysImageUrl()
        var cities :List<CityX>
       cities=cityDB.cityDao().getAll();
         for (i in 0..4) {
             cities[i].imageUrl=image[i]
         }
        return cities
    }
}
