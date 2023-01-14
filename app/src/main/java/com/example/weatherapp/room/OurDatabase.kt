package com.example.weatherapp.room
import android.content.Context
import androidx.room.*
import com.example.weatherapp.model.*

@Database(entities = [CityX::class], version = 1)

@TypeConverters(CloudsTypeConverter::class, CoordTypeConverter::class, MainTypeConverter::class,SysTypeConverter::class,WeatherListTypeConverter::class,WindTypeConverter::class)
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