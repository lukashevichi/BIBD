package by.maxluxs.polyc.data.remote

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteApiHolder {
    private var retrofit: Retrofit? = null
    private var gsonConverterFactory: GsonConverterFactory? = null
    private var client: OkHttpClient? = null

    @Provides
    @Singleton
    fun getClient(url: String): Retrofit {
        return retrofit ?: Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(createGsonConverterFactory())
            .client(createOkHttpClient())
            .build()
            .apply { retrofit = this }
    }

    private fun createOkHttpClient() =
        client ?: OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(createHttpLoggingInterceptor())
            .build()
            .apply { client = this }

    private fun createHttpLoggingInterceptor() =
        HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }

    private fun createGsonConverterFactory() =
        gsonConverterFactory
            ?: GsonConverterFactory
                .create(
                    GsonBuilder()
                        .setLenient()
                        .disableHtmlEscaping()
                        .create()
                )
                .apply { gsonConverterFactory = this }
}

@Module
@InstallIn(SingletonComponent::class)
object Common {

    private const val BASE_URL = "http://10.0.2.2:8080/"

    @Provides
    @Singleton
    fun retrofitService(): RemoteApi =
        RemoteApiHolder.getClient(BASE_URL).create(RemoteApi::class.java)

}