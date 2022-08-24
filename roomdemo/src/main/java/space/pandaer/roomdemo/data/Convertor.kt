package space.pandaer.roomdemo.data

import androidx.room.TypeConverter
import java.util.*

class Convertor {

    @TypeConverter
    fun fromDate(date: Date) = date.time

    @TypeConverter
    fun toDate(value:Long) = Date(value)
}