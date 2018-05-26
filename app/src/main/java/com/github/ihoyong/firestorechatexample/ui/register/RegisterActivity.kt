package com.github.ihoyong.firestorechatexample.ui.register

import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.base.BaseActivity

class RegisterActivity : BaseActivity() {

    private lateinit var presenter: RegisterPresenter

    override fun getResID(): Int = R.layout.activity_register

    override fun init() {
        presenter = RegisterPresenter()
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }

}