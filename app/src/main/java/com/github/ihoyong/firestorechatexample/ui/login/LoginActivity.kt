package com.github.ihoyong.firestorechatexample.ui.login

import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.base.BaseActivity

class LoginActivity : BaseActivity() {

    private lateinit var presenter: LoginPresenter

    override fun getResID(): Int = R.layout.activity_login


    override fun init() {
        presenter = LoginPresenter()
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }

}