package com.saurabh.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabh.BooksRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

lateinit var viewModel: BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = BooksRepository(RetrofitInstance.booksApi)
        val providerFactory = BooksViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this,providerFactory).get(BooksViewModel::class.java)


        viewModel.getBooks()

        viewModel.books.observe(this,{
            rvBooks.adapter = BooksAdapter(it)
            rvBooks.layoutManager = LinearLayoutManager(this)
        })
    }
}