package space.pandaer.roomdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "account")
data class Account(@PrimaryKey(autoGenerate = true) val id : Int = 0,
                   val num:String, val pwd:String,val loginTime : Date)