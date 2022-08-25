package space.pandaer.retrofitdemo

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.pandaer.retrofitdemo.api.MyService
import space.pandaer.retrofitdemo.databinding.ActivityMainBinding
import space.pandaer.retrofitdemo.model.Info

const val TAG = "xixi"
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://eolink.o.apispace.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MyService::class.java)
        MainScope().launch {
            val info = service.getInfo("5")
            binding.text.text = info.result.toString()
        }
    }
}