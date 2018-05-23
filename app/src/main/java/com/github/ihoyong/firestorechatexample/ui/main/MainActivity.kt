package com.github.ihoyong.firestorechatexample.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.base.BaseActivity

class MainActivity : BaseActivity(), Contract.View {

    private lateinit var presenter: MainActivityPresenter

    override fun getResID(): Int = R.layout.activity_main

    override fun init() {
        presenter = MainActivityPresenter()
        presenter.attachView(this)
        presenter.getChatMessage()
    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {

    }

    override fun recyclerview(): RecyclerView = R.id.main_recyclerview as RecyclerView
}
