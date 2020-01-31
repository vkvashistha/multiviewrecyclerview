package com.example.demo

import android.view.View
import android.widget.Button
import com.example.multirecyclerview.MultiViewItem
import com.example.multirecyclerview.MultiViewViewHolder


class ViewHolder3(itemView : View) : MultiViewViewHolder(itemView) {
    override fun onBindVewHolder(position: Int, multiViewItem: MultiViewItem) {
        super.onBindVewHolder(position, multiViewItem)
        val item = multiViewItem.content as Item3
        itemView.findViewById<Button>(R.id.btn_text).text = item.cta
    }
}