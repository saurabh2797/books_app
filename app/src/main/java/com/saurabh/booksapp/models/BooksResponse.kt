package com.saurabh.booksapp.models

data class BooksResponse(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)