package com.example.weatherapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName="cities")
data class CityX(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    @PrimaryKey val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

class CityXTypeConverter {
    @TypeConverter
    fun fromRoomEntity(entity: CityX): String {
        return Gson().toJson(entity)
    }

    @TypeConverter
    fun toRoomEntity(databaseValue: String): CityX {
        return Gson().fromJson(databaseValue, CityX::class.java)
    }
}
class CloudsTypeConverter {
    @TypeConverter
    fun fromRoomEntity(entity: Clouds): String {
        return Gson().toJson(entity)
    }

    @TypeConverter
    fun toRoomEntity(databaseValue: String): Clouds {
        return Gson().fromJson(databaseValue, Clouds::class.java)
    }
}
class CoordTypeConverter {
    @TypeConverter
    fun fromRoomEntity(entity: Coord): String {
        return Gson().toJson(entity)
    }

    @TypeConverter
    fun toRoomEntity(databaseValue: String): Coord {
        return Gson().fromJson(databaseValue, Coord::class.java)
    }
}
class MainTypeConverter {
    @TypeConverter
    fun fromRoomEntity(entity: Main): String {
        return Gson().toJson(entity)
    }

    @TypeConverter
    fun toRoomEntity(databaseValue: String): Main {
        return Gson().fromJson(databaseValue, Main::class.java)
    }
}
class SysTypeConverter {
    @TypeConverter
    fun fromRoomEntity(entity: Sys): String {
        return Gson().toJson(entity)
    }

    @TypeConverter
    fun toRoomEntity(databaseValue: String): Sys {
        return Gson().fromJson(databaseValue, Sys::class.java)
    }
}
class WeatherListTypeConverter {
    @TypeConverter
    fun fromRoomEntity(entity: List<Weather>): String {
        return Gson().toJson(entity)
    }

    @TypeConverter
    fun toRoomEntity(databaseValue: String): List<Weather> {
        val listType = object : TypeToken<List<Weather>>() {}.type
        return Gson().fromJson(databaseValue, listType)
    }
}
class WindTypeConverter {
    @TypeConverter
    fun fromRoomEntity(entity: Wind): String {
        return Gson().toJson(entity)
    }

    @TypeConverter
    fun toRoomEntity(databaseValue: String): Wind {
        return Gson().fromJson(databaseValue, Wind::class.java)
    }
}