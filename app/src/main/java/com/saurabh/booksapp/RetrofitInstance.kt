package com.saurabh.booksapp

import com.saurabh.booksapp.Constants.BASE_URL_BOOKS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL_BOOKS)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        val booksApi by lazy {
            retrofit.create(BooksAPI::class.java)
        }
    }
}