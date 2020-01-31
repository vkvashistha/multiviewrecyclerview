package com.example.multirecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MultiViewViewHolderProvider {
    private val viewHolderTypes : HashMap<Int, Class<out MultiViewViewHolder>> = HashMap()

    fun createViewHolder(parent: ViewGroup, viewType : Int) : MultiViewViewHolder {
        return viewHolderTypes[viewType]!!.getConstructor(View::class.java).newInstance(LayoutInflater.from(parent.context).inflate(viewType, null))
    }

    fun registerViewHolderClass(resId : Int, clazz: Class<out MultiViewViewHolder>) {
        viewHolderTypes[resId] = clazz
    }

}