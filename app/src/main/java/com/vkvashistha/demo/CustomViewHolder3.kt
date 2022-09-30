package com.vkvashistha.demo

import android.view.View
import android.widget.Button
import com.vkvashistha.multiviewrecyclerview.MultiViewItem
import com.vkvashistha.multiviewrecyclerview.MultiViewViewHolder


class CustomViewHolder3(private val listener : MainActivity.MyListener, itemView : View) : com.vkvashistha.multiviewrecyclerview.MultiViewViewHolder(itemView) {
    override fun onBindVewHolder(position: Int, multiViewItem: com.vkvashistha.multiviewrecyclerview.MultiViewItem) {
        super.onBindVewHolder(position, multiViewItem)
        val item = multiViewItem.content as Item3
        itemView.findViewById<Button>(R.id.btn_text).text = item.cta
        itemView.findViewById<Button>(R.id.btn_text).setOnClickListener {
            listener.showToast("Button clicked")
        }
    }
}