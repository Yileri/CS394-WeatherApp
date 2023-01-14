package com.example.weatherapp

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil.setContentView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp.adapter.*
import com.example.weatherapp.data.DataSource
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.switchmaterial.SwitchMaterial


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


