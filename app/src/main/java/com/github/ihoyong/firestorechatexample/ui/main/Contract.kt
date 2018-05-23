package com.github.ihoyong.firestorechatexample.ui.main

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

interface Contract {

    interface View {

        fun recyclerview(): RecyclerView
    }

    interface Presenter {

        fun attachView(view: View, context: Context)

        fun getChatMessage()
    }
}