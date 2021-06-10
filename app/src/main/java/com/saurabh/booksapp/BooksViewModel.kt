package com.saurabh.booksapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurabh.BooksRepository
import com.saurabh.booksapp.models.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BooksViewModel(
val repository: BooksRepository
) : ViewModel() {
    val books : MutableLiveData<List<Item>> = MutableLiveData()

  fun getBooks() = viewModelScope.launch(Dispatchers.IO) {
      val response = repository.getBooks()
      books.postValue(response.items)
  }
}