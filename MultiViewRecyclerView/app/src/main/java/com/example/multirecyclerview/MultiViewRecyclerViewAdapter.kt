package com.example.multirecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class MultiViewRecyclerViewAdapter(val viewHolderProvider: MultiViewViewHolderProvider) : ListAdapter<MultiViewItem, MultiViewViewHolder>(
    ItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewViewHolder {
        return viewHolderProvider.createViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: MultiViewViewHolder, position: Int) {
        holder.onBindVewHolder(position, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).reseId
    }
}