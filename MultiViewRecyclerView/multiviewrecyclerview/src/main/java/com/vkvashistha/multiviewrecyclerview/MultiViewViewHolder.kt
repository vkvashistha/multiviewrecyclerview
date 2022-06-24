package com.vkvashistha.multiviewrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class MultiViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val eventListeners = ArrayList<EventListener>()
    open fun addEventListener(eventListener : EventListener) {
        eventListeners.add(eventListener)
    }

    open fun removeEventListener(eventListener: EventListener) {
        eventListeners.remove(eventListener)
    }

    open fun dispatchEvent( eventType:Int,  position : Int, eventParams:Map<String,Any>) {
        for(eventListener in eventListeners) {
            eventListener.onEventOccurred(eventType, position, eventParams)
        }
    }

    open fun onBindVewHolder(position:Int, multiViewItem: MultiViewItem) {
        attachClickEvent(position, multiViewItem)
    }

    open fun onViewDetached(position: Int, multiViewItem: MultiViewItem) {

    }

    open fun attachClickEvent(position: Int, multiViewItem: MultiViewItem) {
        itemView.setOnClickListener {
            dispatchEvent(0, position, mapOf(Pair("item", multiViewItem)))
        }
    }

    interface EventListener {
        fun onEventOccurred(eventType:Int, position:Int, eventParams: Map<String, Any>)
    }
}