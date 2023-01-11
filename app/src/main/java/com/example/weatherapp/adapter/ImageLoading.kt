package com.example.weatherapp.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.squareup.picasso.Picasso

class ImageLoading {
    object ImageBindingAdapter {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            Picasso.get()
                .load(imageUrl)
                .into(view)
        }
    }

    val cityImageUrl = MutableLiveData<String>()
    val cityIstanbulImageUrl = "https://www.gruppal.com/blog/public/assets/img/vapurlar-1573135623557.jpg"
    val cityAnkaraImageUrl = "https://upload.wikimedia.org/wikipedia/commons/c/ce/An%C4%B1tkabir%2C_Ankara.jpg"
    val cityIzmirImageUrl = "https://www.shutterstock.com/image-photo/izmir-clock-tower-famous-became-260nw-716723134.jpg"



}