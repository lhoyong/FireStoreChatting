package com.github.ihoyong.firestorechatexample.ui.register

import com.google.firebase.auth.FirebaseAuth

class RegisterPresenter : Contract.Presenter {

    private lateinit var view: Contract.View

    override fun attachView(view: Contract.View) {
        this.view = view
    }

    override fun deathView() {

    }

    override fun submit(id: String, pw: String, callback: (Boolean) -> Unit) {

        if (id.isNotEmpty() && pw.isNotEmpty()) {
            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(id, pw)
                    .addOnCompleteListener {
                        if (it.isSuccessful) callback(true)
                        else callback(false)
                    }.addOnFailureListener {
                        it.printStackTrace()
                    }
        } else {
            callback(false)
        }

    }

}