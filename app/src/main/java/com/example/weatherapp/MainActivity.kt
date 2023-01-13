package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.adapter.*
import com.example.weatherapp.data.DataSource
import com.example.weatherapp.model.CityX
import com.example.weatherapp.repository.CityRepo
import com.example.weatherapp.room.OurDatabase
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var cityDB:OurDatabase
    val repository=CityRepo(cityDB)
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


    suspend fun writeToDatabase(){        //BURDA DATABASE EKLİYORUZ
    repository.AddTheCities()
    }



    suspend fun readFromDatabase():List<CityX>{   //BURDA DATABASEDEN ÇEKİYORUZ

        val dataList:List<CityX> =repository.getCities()

        return dataList
}



    }


