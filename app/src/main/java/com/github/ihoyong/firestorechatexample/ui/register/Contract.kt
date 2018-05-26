package com.github.ihoyong.firestorechatexample.ui.register

interface Contract {

    interface View {

    }

    interface Presenter {

        fun attachView(view: View)
        fun deathView()

        fun submit(id: String, pw: String, callback: (Boolean) -> Unit)
    }
}
