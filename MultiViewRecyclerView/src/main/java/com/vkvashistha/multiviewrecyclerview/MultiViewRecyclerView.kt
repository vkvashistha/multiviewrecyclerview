package com.vkvashistha.multiviewrecyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

open class MultiViewRecyclerView : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs : AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int) : super(context, attrs, defStyleAttr)

    override fun getAdapter(): MultiViewRecyclerViewAdapter? {
        return super.getAdapter() as? MultiViewRecyclerViewAdapter
    }
}