package com.saurabh

import com.saurabh.booksapp.BooksAPI

class BooksRepository(
    private val api: BooksAPI
) {
suspend fun getBooks() = api.getAllBooks()
}