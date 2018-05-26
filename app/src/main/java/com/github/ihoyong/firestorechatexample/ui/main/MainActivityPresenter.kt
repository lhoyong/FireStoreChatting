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
    private lateinit var context: Context

    private lateinit var firestore: FirebaseFirestore

    private lateinit var mAdapter: MainRecyclerViewAdapter
    private lateinit var adapterModel: com.github.ihoyong.firestorechatexample.adapter.Contract.Model
    private lateinit var adapterView: com.github.ihoyong.firestorechatexample.adapter.Contract.View

    override fun attachView(view: Contract.View, context: Context) {
        this.view = view
        this.context = context

        // 파이어스토어 연결
        firestore = FirebaseFirestore.getInstance()
    }

    override fun getChatMessage() {
        //TODO 채팅 내역 받기

        mAdapter = MainRecyclerViewAdapter(context)
        adapterModel = mAdapter
        adapterView = mAdapter

        // Recyclerview 세팅
        view.recyclerview().apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        // firestore에서 데이터 불러오기
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
                    view.recyclerview().scrollToPosition(mAdapter.itemCount - 1)
                }

                else -> {
                }
            }
        }
    }

    // 메시지 보내기
    override fun sendMessage(message: String, callback: (String) -> Unit) {
        if (message.isEmpty()) callback("empty")    // 값이 없을 경우
        else {
            firestore.collection("Chat")
                    .add(chatItem(message, Date().time))
                    .addOnSuccessListener {
                        // 성공일 경우
                        callback("success")
                    }
                    .addOnFailureListener {
                        // 실패일경우
                        callback("fail")
                    }
        }
    }
}