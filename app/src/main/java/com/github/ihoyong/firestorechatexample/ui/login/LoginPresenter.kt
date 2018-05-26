package com.github.ihoyong.firestorechatexample.ui.login

class LoginPresenter : Contract.Presenter {

    private lateinit var view: Contract.View

    override fun attachView(view: Contract.View) {
        this.view = view
    }

    override fun deathView() {
    }

    override fun submit(id: String, pw: String) {

    }
}