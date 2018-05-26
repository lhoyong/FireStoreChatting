package com.github.ihoyong.firestorechatexample.ui.login

import android.content.Intent
import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.base.BaseActivity
import com.github.ihoyong.firestorechatexample.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private lateinit var presenter: LoginPresenter

    override fun getResID(): Int = R.layout.activity_login


    override fun init() {
        presenter = LoginPresenter()

        // Register Button
        login_register.setOnClickListener {
            Intent(this, RegisterActivity::class.java).apply {
                startActivity(this)
            }
        }

        //
        login_submit.setOnClickListener {
            presenter.submit(login_id.text.toString(), login_pw.text.toString())
        }
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }

}