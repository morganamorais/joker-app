package co.tiagoaguiar.tutorial.jokerappdev.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HTTPClient {

    private const val BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"
    const val API_KEY = "f92bf6ec-fb8d-4dbf-b7c8-fa7a13e38a31"

    private fun httpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
    fun retrofit() =  Retrofit.Builder()
        .baseUrl(BASE_URL) // vai
        .addConverterFactory(GsonConverterFactory.create()) // criar o cnversor pra gente
        .client(httpClient())
        .build() // o que cria o retrofit pra gente
    }


