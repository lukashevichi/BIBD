package by.maxluxs.polyc.remote

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

object RemoteApiHolder {
    private var retrofit: Retrofit? = null

    fun getClient(url: String): Retrofit {
        return retrofit ?: Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build().apply {
                Log.e("!!!", "this")
                retrofit = this
            }
    }
}

object Common {
    private val BASE_URL = "http://127.0.0.1:8080/"
    val retrofitService: RemoteApi
        get() = RemoteApiHolder.getClient(BASE_URL).create(RemoteApi::class.java)
}