package com.example.weatherapp.adapter

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.findFragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp.CityDetailActivity
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R
import com.example.weatherapp.city_detail
import com.example.weatherapp.databinding.FragmentCityLayoutBinding
import com.example.weatherapp.model.City


class ItemAdapter(val dataset: List<City>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView = view.findViewById<TextView>(R.id.nameView)
        val conditionView = view.findViewById<TextView>(R.id.conditionView)
        val tempView = view.findViewById<TextView>(R.id.tempView)
        val details = view.findViewById<TextView>(R.id.detailView)

        lateinit var city: City

        init {
            details.setOnClickListener {
                val showDetailIntent = Intent(itemView.context, CityDetailActivity::class.java)
                showDetailIntent.putExtra(CITY_KEY, city)
                itemView.context.startActivity(showDetailIntent)
            }
        }

        companion object {
            private val CITY_KEY = "CITY"
        }

        fun bind(city: City) {
            this.city = city
            nameView.text = city.name
            conditionView.text = city.condition
            tempView.text = city.temp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_city_layout, parent, false)
        return ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {


        val city = dataset[position]
        holder.bind(city)


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}



