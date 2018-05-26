package com.github.ihoyong.firestorechatexample.ui.register

import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.base.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {

    private lateinit var presenter: RegisterPresenter

    override fun getResID(): Int = R.layout.activity_register

    override fun init() {
        presenter = RegisterPresenter()

        register_submit.setOnClickListener {
            presenter.submit(register_id.text.toString().trim(), register_pw.text.toString().trim()) {
                if (it) finish(
                )
            }
        }
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }

}