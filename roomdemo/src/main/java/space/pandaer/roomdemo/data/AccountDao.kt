package space.pandaer.roomdemo.data

import androidx.room.*
import space.pandaer.roomdemo.model.Account

@Dao
interface AccountDao {

    @Query("SELECT * From account")
    fun getAccounts() : List<Account>

    @Query("SELECT * From account WHERE num == (:account)")
    fun getAccount(account : String) : Account

    @Insert
    fun addAccount(account:Account)

    @Update
    fun updateAccount(accont:Account)

    @Delete
    fun deleteAcount(account: Account)

}