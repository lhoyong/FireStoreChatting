package com.github.ihoyong.firestorechatexample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.firestorechatexample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var presenter: MainActivityPresenter

    override fun chatMessageClear() =  main_editText.setText("")

    override fun chatRecyclerview(): RecyclerView = main_recyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        presenter = MainActivityPresenter()

        presenter.attachView(this)
        presenter.attachRecyclerView(this)

        presenter.getChatMessage()

        // send button
        main_submit.setOnClickListener { presenter.sendMessage(main_editText.text.toString()) }

    }


}
