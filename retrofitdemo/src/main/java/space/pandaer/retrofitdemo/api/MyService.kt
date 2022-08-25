package space.pandaer.retrofitdemo.api

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import space.pandaer.retrofitdemo.model.Info

interface MyService {
    @FormUrlEncoded
    @POST("xhdq/common/joke/getJokesByRandom")
    @Headers(
        "X-APISpace-Token: rgippbfyl7bju3fz9vr6hxcgoy0appwu",
        "Authorization-Type: apikey",
        "Content-Type: application/x-www-form-urlencoded"
    )
    suspend fun getInfo(@Field("pageSize") size : String) : Info

}