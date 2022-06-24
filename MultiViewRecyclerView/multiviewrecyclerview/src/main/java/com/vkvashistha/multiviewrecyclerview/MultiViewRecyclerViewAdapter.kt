package com.vkvashistha.multiviewrecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class MultiViewRecyclerViewAdapter(val viewHolderProvider: MultiViewViewHolderProvider) : ListAdapter<MultiViewItem, MultiViewViewHolder>(
    ItemDiffCallback()
), MultiViewViewHolder.EventListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewViewHolder {
        val viewHolder = viewHolderProvider.createViewHolder(parent, viewType)
        viewHolder.addEventListener(this)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MultiViewViewHolder, position: Int) {
        holder.onBindVewHolder(position, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).reseId
    }

    private val eventListeners = ArrayList<MultiViewViewHolder.EventListener>()
    open fun addEventListener(eventListener : MultiViewViewHolder.EventListener) {
        eventListeners.add(eventListener)
    }

    open fun removeEventListener(eventListener: MultiViewViewHolder.EventListener) {
        eventListeners.remove(eventListener)
    }

    override fun onEventOccurred(eventType: Int, position: Int, eventParams: Map<String, Any>) {
        for(event in eventListeners) {
            event.onEventOccurred(eventType, position, eventParams)
        }
    }
}