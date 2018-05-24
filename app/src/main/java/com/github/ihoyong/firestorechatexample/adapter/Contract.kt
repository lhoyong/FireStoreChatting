package com.github.ihoyong.firestorechatexample.adapter

import com.github.ihoyong.firestorechatexample.model.chatItem

interface Contract {

    interface Model {
        fun addItem(e: chatItem)
    }

    interface View {

        fun changeView()
    }
}