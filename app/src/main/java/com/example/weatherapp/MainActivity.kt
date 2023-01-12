package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil.setContentView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp.Retrofit.ApiInterface
import com.example.weatherapp.adapter.*
import com.example.weatherapp.data.DataSource
import com.example.weatherapp.model.CityX
import com.google.android.material.navigation.NavigationView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cities = DataSource(this).loadCities()
        val rv: RecyclerView = findViewById(R.id.recyclerView)
        rv.adapter = ItemAdapter(cities)
        rv.setHasFixedSize(true)



        drawerLayout = findViewById(R.id.main_layout)
        val navView: NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            val intent = Intent(this, MainActivity::class.java)
            val aboutIntent = Intent(this, AboutActivity::class.java)
            val creditIntent = Intent(this, CreditActivity::class.java)

            when (it.itemId) {
                R.id.about -> startActivity(aboutIntent)

                R.id.credit -> startActivity(creditIntent)

                R.id.home -> startActivity(intent)
            }

            true
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            true
        }

        return super.onOptionsItemSelected(item)
    }


    fun cityApi():CityX{
val retrofit:Retrofit=Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/weather?q=London&units=metric&appid=001f4abe47262aa2424f9aed04fa56c1")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

        val api:ApiInterface=retrofit.create(ApiInterface::class.java)
        val city =api.getLondon()
       return city
    }



    }


