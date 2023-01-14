package com.example.weatherapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.CityDetailActivity
import com.example.weatherapp.R
import com.example.weatherapp.model.City
import com.squareup.picasso.Picasso



class ItemAdapter(val dataset: List<City>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView = view.findViewById<TextView>(R.id.nameView)
        val conditionView = view.findViewById<TextView>(R.id.conditionView)
        val tempView = view.findViewById<TextView>(R.id.tempView)
        val details = view.findViewById<TextView>(R.id.detailView)
        val images=view.findViewById<ImageView>(R.id.city_image)


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
            Picasso.get().load(city.imageUrl).into(images);
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_city_layout, parent, false)
        return ItemAdapter.ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {


        val city = dataset[position]
        holder.bind(city)


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}