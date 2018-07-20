package com.github.ihoyong.firestorechatexample.ui.main

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ihoyong.firestorechatexample.adapter.MainRecyclerViewAdapter
import com.github.ihoyong.firestorechatexample.model.chatItem
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener
import java.util.*

class MainActivityPresenter : Contract.Presenter, EventListener<QuerySnapshot> {

    private lateinit var view: Contract.View

    private lateinit var firestore: FirebaseFirestore

    private lateinit var mAdapter: MainRecyclerViewAdapter
    private lateinit var adapterModel: com.github.ihoyong.firestorechatexample.adapter.Contract.Model
    private lateinit var adapterView: com.github.ihoyong.firestorechatexample.adapter.Contract.View

    override fun attachView(view: Contract.View) {
        this.view = view

        // 파이어스토어 연결
        firestore = FirebaseFirestore.getInstance()

        // 키보드 내리기
        //hidekeyboard.hideKeyboard()
    }

    // Recyclerview
    override fun attachRecyclerView(mContext: Context) {

        mAdapter = MainRecyclerViewAdapter(mContext)
        adapterModel = mAdapter
        adapterView = mAdapter


        view.chatRecyclerview().apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    // firestore에서 데이터 불러오기  get Message From FireStore
    //TODO 채팅 내역 받기
    override fun getChatMessage() {

        firestore.collection("Chat")
                .orderBy("time")
                .addSnapshotListener(this)
    }

    override fun onEvent(snapshot: QuerySnapshot?, p1: FirebaseFirestoreException?) {
        for (docu in snapshot!!.documentChanges) {
            when (docu.type) {

                DocumentChange.Type.ADDED -> {  // 데이터가 추가 됬을경우
                    val item = docu.document.toObject(chatItem::class.java)
                    adapterModel.addItem(item)
                    adapterView.changeView()
                    view.chatRecyclerview().scrollToPosition(mAdapter.itemCount - 1)
                }

                else -> {
                }
            }
        }
    }

    // 메시지 보내기 Send Message
    override fun sendMessage(message: String) {
        if (message.isNotEmpty()) {
            firestore.collection("Chat")
                    .add(chatItem(message, Date().time))
                    .addOnSuccessListener {
                        view.chatMessageClear()
                    }
                    .addOnFailureListener {


                    }
        }
    }

}