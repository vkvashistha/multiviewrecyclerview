package com.example.demo

import android.view.View
import android.widget.ImageView
import com.example.multirecyclerview.MultiViewItem
import com.example.multirecyclerview.MultiViewViewHolder


class ViewHolder2(itemView : View) : MultiViewViewHolder(itemView) {
    override fun onBindVewHolder(position: Int, multiViewItem: MultiViewItem) {
        super.onBindVewHolder(position, multiViewItem)
        val itemView = itemView.findViewById<ImageView>(R.id.iv_image)
        val item = multiViewItem.content as Item2
        itemView.setImageResource(item.resId)
    }
}