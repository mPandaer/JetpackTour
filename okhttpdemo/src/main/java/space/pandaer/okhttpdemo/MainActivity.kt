package space.pandaer.okhttpdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val client by lazy {
        OkHttpClient.Builder().callTimeout(5,TimeUnit.SECONDS).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = HttpUrl.Builder().addQueryParameter("type","json").build()
        val request = Request.Builder().apply {
            url("https://eolink.o.apispace.com/xhdq/common/joke/getJokesByRandom")
            val headers = Headers.Builder().apply {
                add("X-APISpace-Token: rgippbfyl7bju3fz9vr6hxcgoy0appwu")
                add("Authorization-Type: apikey")
                add("Content-Type: application/x-www-form-urlencoded")

            }.build()
            headers(headers)
            val body = FormBody.Builder().apply {
                add("pageSize","5")
            }.build()
            post(body)
        }.build()
        val call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("xixi", "fali to get ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("xixi", "${response.body?.string()}")
            }

        })
    }
}