package com.example.weatherapp.room
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.model.CityX

@Database(entities = [CityX::class], version = 1)
abstract class OurDatabase :RoomDatabase(){

    abstract  fun cityDao(): CityDao

    companion object{
        @Volatile
        private var INSTANCE: OurDatabase?=null

        fun getDatabase(context:Context): OurDatabase {

            if(INSTANCE ==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context, OurDatabase::class.java,"citiesDB")
                        .build()
                }
            }


            return INSTANCE!!
        }


    }
}