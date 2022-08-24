package space.pandaer.roomdemo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import space.pandaer.roomdemo.model.Account


@Database(entities = [Account::class], version = 2, exportSchema = false)
@TypeConverters(Convertor::class)
abstract class AccountDatabase : RoomDatabase() {
    abstract val accountDao:AccountDao
}