package com.vkvashistha.multiviewrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MultiViewViewHolderProvider {
    private val viewHolderTypes : HashMap<Int, Class<out MultiViewViewHolder>> = HashMap()
    private val viewHolderFactories = HashMap<Int, MultiViewHolderFactory>()


    fun createViewHolder(parent: ViewGroup, viewType : Int) : MultiViewViewHolder {
        return if(viewHolderFactories[viewType] != null) {
            viewHolderFactories[viewType]!!.createInstance(parent,viewType)
        } else {
            viewHolderTypes[viewType]!!.getConstructor(View::class.java).newInstance(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
        }
    }

    fun registerViewHolderClass(resId : Int, clazz: Class<out MultiViewViewHolder>) {
        viewHolderTypes[resId] = clazz
    }

    fun registerViewHolderFactory(viewType : Int, viewHolderFactory: MultiViewHolderFactory) {
        viewHolderFactories[viewType] = viewHolderFactory
    }
}
interface MultiViewHolderFactory {
    fun createInstance(parent: View, viewType : Int) : MultiViewViewHolder
}