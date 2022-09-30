package com.vkvashistha.multiviewrecyclerview

import android.view.View
import android.widget.TextView

open class SimpleListViewHolder(itemView: View) : MultiViewViewHolder(itemView) {
    override fun onBindVewHolder(position: Int, multiViewItem: MultiViewItem) {
        super.onBindVewHolder(position, multiViewItem)
        itemView.findViewById<TextView>(R.id.tv_item).text = multiViewItem.content.toString()
    }
}