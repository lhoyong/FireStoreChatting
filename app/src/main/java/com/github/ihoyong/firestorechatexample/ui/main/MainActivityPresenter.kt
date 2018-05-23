package com.github.ihoyong.firestorechatexample.ui.main

import android.content.Context
import com.github.ihoyong.firestorechatexample.adapter.MainRecyclerViewAdapter
import com.github.ihoyong.firestorechatexample.model.chatItem
import com.google.firebase.firestore.*

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

        firestore = FirebaseFirestore.getInstance()
    }

    override fun getChatMessage() {
        //TODO 채팅 내역 받기

        mAdapter = MainRecyclerViewAdapter(context)
        adapterModel = mAdapter
        adapterView = mAdapter

        view.recyclerview().apply {
            adapter = mAdapter
        }

        firestore.collection("Chat")
                .orderBy("time")
                .addSnapshotListener(this)
    }

    override fun onEvent(snapshot: QuerySnapshot?, p1: FirebaseFirestoreException?) {
        for (docu in snapshot!!.documentChanges) {
            when (docu.type) {

                DocumentChange.Type.ADDED -> {
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
}