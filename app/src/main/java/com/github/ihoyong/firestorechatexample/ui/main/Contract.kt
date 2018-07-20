package com.github.ihoyong.firestorechatexample.ui.main

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

interface Contract {

    interface View {

        fun chatRecyclerview(): RecyclerView
        fun chatMessageClear()
    }

    interface Presenter {

        fun attachView(view: View)
        fun attachRecyclerView(mContext: Context)

        fun getChatMessage()

        fun sendMessage(message: String)
    }
}