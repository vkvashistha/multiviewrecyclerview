package com.vkvashistha.demo

import android.view.LayoutInflater
import android.view.View
import com.vkvashistha.multiviewrecyclerview.MultiViewHolderFactory
import com.vkvashistha.multiviewrecyclerview.MultiViewViewHolder

class ViewHolder3Factory(val listener : MainActivity.MyListener) :
    com.vkvashistha.multiviewrecyclerview.MultiViewHolderFactory {
    override fun createInstance(parent: View, viewType: Int): com.vkvashistha.multiviewrecyclerview.MultiViewViewHolder {
        return CustomViewHolder3(listener, LayoutInflater.from(parent.context).inflate(R.layout.item_type3, null))
    }
}