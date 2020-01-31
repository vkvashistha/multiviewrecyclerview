package com.example.multirecyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.multirecyclerview.MultiViewItem

class ItemDiffCallback : DiffUtil.ItemCallback<MultiViewItem>() {
    override fun areItemsTheSame(oldItem: MultiViewItem, newItem: MultiViewItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MultiViewItem, newItem: MultiViewItem): Boolean {
        return oldItem.content == newItem.content
    }
}