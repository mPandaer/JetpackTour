package space.pandaer.roomdemo

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import space.pandaer.roomdemo.data.AccountDatabase
import space.pandaer.roomdemo.data.AccountMigration
import space.pandaer.roomdemo.databinding.ActivityMainBinding
import space.pandaer.roomdemo.model.Account
import java.util.*

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val database by lazy { Room
        .databaseBuilder(this,AccountDatabase::class.java,"account_db")
        .addMigrations(AccountMigration)
        .build() }
    private val accountDao by lazy { database.accountDao }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.save.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                val account = binding.account.text.toString()
                val pwd = binding.pwd.text.toString()
                if (account.isNotEmpty() && pwd.isNotEmpty()) {
                    accountDao.addAccount(Account(num = account, pwd = pwd, loginTime = Date()))
                }
            }

        }

        binding.query.setOnClickListener {
            val account = binding.account.text.toString()
            if (account.isNotEmpty()) {
                lifecycleScope.launch(Dispatchers.Main) {
                    binding.info.text = withContext(Dispatchers.IO){
                        accountDao.getAccount(account).toString()
                    }
                }

            }

        }
    }
}