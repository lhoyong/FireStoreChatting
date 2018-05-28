package com.github.ihoyong.firestorechatexample.ui.login

import com.google.firebase.auth.FirebaseAuth

class LoginPresenter : Contract.Presenter {

    private lateinit var view: Contract.View
    private lateinit var firebaseAuth: FirebaseAuth

    override fun attachView(view: Contract.View) {
        this.view = view
        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun deathView() {
    }

    override fun submit(id: String, pw: String, callback: (Boolean) -> Unit) {
        if (id.isNotEmpty() && pw.isNotEmpty()) {
            // 로그인이 안되있을 시
            if (!validateLogin()) {
                signWithFirebase(id, pw) {
                    callback(it)
                }
            }else callback(true)
        }
    }

    // 로그인 여부 확인
    private fun validateLogin(): Boolean {
        return firebaseAuth.currentUser != null
    }

    private fun signWithFirebase(id: String, pw: String, callback: (Boolean) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(id, pw)
                .addOnCompleteListener {
                    if (it.isSuccessful) callback(true)
                    else callback(false)
                }
    }
}