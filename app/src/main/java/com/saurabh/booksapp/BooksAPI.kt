package com.saurabh.booksapp

import com.saurabh.booksapp.Constants.BOOKS_API_KEY
import com.saurabh.booksapp.models.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPI {
    @GET("/books/v1/volumes")
    suspend fun getAllBooks(
        @Query("q") q:String="literature",
        @Query("key") key:String=BOOKS_API_KEY
    ): BooksResponse
}