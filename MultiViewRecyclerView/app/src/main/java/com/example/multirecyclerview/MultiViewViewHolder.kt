package com.example.multirecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class MultiViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun onBindVewHolder(position:Int, multiViewItem: MultiViewItem) {

    }

    open fun onViewDetached(position: Int, multiViewItem: MultiViewItem) {

    }

}