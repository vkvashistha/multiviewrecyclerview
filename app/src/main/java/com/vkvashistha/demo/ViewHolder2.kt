package com.vkvashistha.demo

import android.view.View
import android.widget.ImageView
import com.vkvashistha.multiviewrecyclerview.MultiViewItem
import com.vkvashistha.multiviewrecyclerview.MultiViewViewHolder


class ViewHolder2(itemView : View) : MultiViewViewHolder(itemView) {
    override fun onBindVewHolder(position: Int, multiViewItem: MultiViewItem) {
        super.onBindVewHolder(position, multiViewItem)
        val itemView = itemView.findViewById<ImageView>(R.id.iv_image)
        val item = multiViewItem.content as Item2
        itemView.setImageResource(item.resId)
    }
}