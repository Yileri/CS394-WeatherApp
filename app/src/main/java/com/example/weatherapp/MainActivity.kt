package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.adapter.*
import com.example.weatherapp.model.CityX
import com.example.weatherapp.repository.CityRepo
import com.example.weatherapp.room.OurDatabase
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cityDB: OurDatabase = OurDatabase.getDatabase(applicationContext)
        val repository= CityRepo(this,cityDB)

        fun writeToDatabase(){        //BURDA DATABASE EKLİYORUZ
            repository.AddTheCities()
        }
        fun readFromDatabase():List<CityX>{   //BURDA DATABASEDEN ÇEKİYORUZ

            val dataList:List<CityX> =repository.getCities()

            return dataList
        }
        writeToDatabase()
        val list :List<CityX> =readFromDatabase()


        val rv: RecyclerView = findViewById(R.id.recyclerView)
        rv.adapter = ItemAdapter(list)
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

            // ha bunlar replace fragment olacak uşaklar uy
            when (it.itemId) {
                R.id.about -> startActivity(aboutIntent)

                R.id.credit -> startActivity(creditIntent)

                R.id.home -> startActivity(intent)

                R.id.theme_settings -> startActivity(Intent(this, ThemeActivity::class.java))

            }

            /*
            navView.findViewById<SwitchMaterial>(R.id.switch_theme).setOnCheckedChangeListener { _, isChecked ->

                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }

            }
             */
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment, title :String){

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        setTitle(title)
        drawerLayout.closeDrawers()

    }





    }


