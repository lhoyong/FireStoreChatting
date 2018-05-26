package com.github.ihoyong.firestorechatexample.ui.login

interface Contract{

    interface View{

    }

    interface Presenter{
        fun attachView(view: View)
        fun deathView()

        // Login
        fun submit(id: String, pw: String)
    }
}