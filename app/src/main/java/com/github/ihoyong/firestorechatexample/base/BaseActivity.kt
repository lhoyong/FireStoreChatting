package com.github.ihoyong.firestorechatexample.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResID())
        init()
    }

    override fun onResume() {
        super.onResume()
        resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        destroy()

    }

    override fun onPause() {
        super.onPause()
        pause()
    }

    abstract fun getResID(): Int

    abstract fun init()

    abstract fun resume()

    abstract fun pause()

    abstract fun destroy()

}