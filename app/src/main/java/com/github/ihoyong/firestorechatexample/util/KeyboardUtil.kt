package com.github.ihoyong.firestorechatexample.util

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

object KeyboardUtil {

    fun hideKeyboard(et: EditText, context: Context) {
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(et.windowToken, 0)
    }
}