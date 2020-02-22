package com.example.demo

import android.view.LayoutInflater
import android.view.View
import com.example.multirecyclerview.MultiViewHolderFactory
import com.example.multirecyclerview.MultiViewViewHolder

class ViewHolder3Factory(val listener : MainActivity.MyListener) : MultiViewHolderFactory {
    override fun createInstance(parent: View, viewType: Int): MultiViewViewHolder {
        return CustomViewHolder3(listener, LayoutInflater.from(parent.context).inflate(R.layout.item_type3, null))
    }
}