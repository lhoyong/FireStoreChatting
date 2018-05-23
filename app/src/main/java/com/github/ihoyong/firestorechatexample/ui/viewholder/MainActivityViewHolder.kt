package com.github.ihoyong.firestorechatexample.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.firestorechatexample.R

class MainActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val message = itemView.findViewById<TextView>(R.id.main_item_message)

    fun bind(msg: String) {
        message.text = msg
    }
}