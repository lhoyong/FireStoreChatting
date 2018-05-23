package com.github.ihoyong.firestorechatexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.model.chatItem
import com.github.ihoyong.firestorechatexample.ui.viewholder.MainActivityViewHolder


class MainRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Contract.Model, Contract.View {

    private var item: MutableList<chatItem>

    init {
        item = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainActivityViewHolder(LayoutInflater.from(context).inflate(R.layout.main_item, parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainActivityViewHolder).bind(item[position].message)
    }

    override fun addItem(e: chatItem) {
        item.add(e)
    }

    override fun changeView() {
        notifyDataSetChanged()
    }

}