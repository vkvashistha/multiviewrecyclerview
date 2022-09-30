package com.vkvashistha.demo

import android.view.View
import android.widget.TextView
import com.vkvashistha.multiviewrecyclerview.MultiViewItem
import com.vkvashistha.multiviewrecyclerview.MultiViewViewHolder

class ViewHolder1(itemView : View) : MultiViewViewHolder(itemView) {
    override fun onBindVewHolder(position: Int, multiViewItem: MultiViewItem) {
        super.onBindVewHolder(position, multiViewItem)
        val tv_text = itemView.findViewById<TextView>(R.id.tv_text)
        val item = multiViewItem.content as Item1
        tv_text.text =  item.text
    }
}