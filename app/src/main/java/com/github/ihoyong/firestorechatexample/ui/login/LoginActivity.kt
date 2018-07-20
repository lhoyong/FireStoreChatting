package com.github.ihoyong.firestorechatexample.ui.login

import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.base.BaseActivity
import com.github.ihoyong.firestorechatexample.ui.main.MainActivity
import com.github.ihoyong.firestorechatexample.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.intentFor

class LoginActivity : BaseActivity(), Contract.View {

    private lateinit var presenter: LoginPresenter

    override fun getResID(): Int = R.layout.activity_login


    override fun init() {
        presenter = LoginPresenter()

        presenter.attachView(this)

        login_id.setText("test@test.com")
        login_pw.setText("000000")

        // Register Button
        login_register.setOnClickListener { startActivity(intentFor<RegisterActivity>()) }

        // 로그인 버튼
        login_submit.setOnClickListener {
            presenter.submit(login_id.text.toString(), login_pw.text.toString()) {
                if (it) {
                    startActivity(intentFor<MainActivity>()).apply{finish()}
                }
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