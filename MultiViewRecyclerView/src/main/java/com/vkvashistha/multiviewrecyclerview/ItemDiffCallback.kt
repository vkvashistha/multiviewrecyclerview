package com.vkvashistha.multiviewrecyclerview

import androidx.recyclerview.widget.DiffUtil

open class ItemDiffCallback : DiffUtil.ItemCallback<MultiViewItem>() {
    override fun areItemsTheSame(oldItem: MultiViewItem, newItem: MultiViewItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MultiViewItem, newItem: MultiViewItem): Boolean {
        return oldItem.content == newItem.content
    }
}