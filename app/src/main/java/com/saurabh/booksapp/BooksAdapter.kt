package com.saurabh.booksapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saurabh.booksapp.models.Item
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(
    private val books : List<Item>
):RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    inner class BooksViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false))
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = books[position]
        holder.itemView.apply {
            Glide.with(this).load(book.volumeInfo.imageLinks.thumbnail).into(ivBook)
            tvBookTitle.text = book.volumeInfo.title
            tvPageCount.text = book.volumeInfo.pageCount.toString()
        }
    }

    override fun getItemCount(): Int {
       return books.size
    }
}