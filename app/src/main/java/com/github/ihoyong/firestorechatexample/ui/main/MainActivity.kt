package com.github.ihoyong.firestorechatexample.ui.main

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.firestorechatexample.R
import com.github.ihoyong.firestorechatexample.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), Contract.View {

    private lateinit var presenter: MainActivityPresenter

    override fun getResID(): Int = R.layout.activity_main

    override fun init() {
        presenter = MainActivityPresenter()
        presenter.attachView(this, this)
        presenter.getChatMessage()

        // 전송 버튼
        main_submit.setOnClickListener {
            presenter.sendMessage(main_editText.text.toString()) {
                when (it) {
                    "empty" -> {
                    }
                    "success" -> {
                        main_editText.setText("")
                    }
                    "fail" -> Toast.makeText(this, "서버연결이 실패했습니다.", Toast.LENGTH_SHORT).show()
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

    override fun recyclerview(): RecyclerView = main_recyclerview
}
