package com.vkvashistha.multiviewrecyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MultiViewRecyclerViewBuilder(private val recyclerView: RecyclerView) {
    private val viewHolderProvider = MultiViewViewHolderProvider()
    private val items: ArrayList<MultiViewItem> = ArrayList()
    private val adapter: MultiViewRecyclerViewAdapter
    private var orientation = RecyclerView.VERTICAL
    private var layoutManager:RecyclerView.LayoutManager? = null

    init {
        viewHolderProvider.registerViewHolderClass(
            R.layout.default_string_list,
            SimpleListViewHolder::class.java
        )
        adapter = MultiViewRecyclerViewAdapter(viewHolderProvider)
    }

    companion object {
        fun of(recyclerView: MultiViewRecyclerView) : MultiViewRecyclerViewBuilder {
            return MultiViewRecyclerViewBuilder(recyclerView)
        }
    }

    fun withViewHolderResource(id:Int, clazz: Class<out MultiViewViewHolder>) : MultiViewRecyclerViewBuilder {
        viewHolderProvider.registerViewHolderClass(id, clazz)
        return this
    }

    fun withViewHolderFactory(res:Int, viewHolderFactory: MultiViewHolderFactory) {
        viewHolderProvider.registerViewHolderFactory(res, viewHolderFactory)
    }

    fun addItems(viewHolderResourceId:Int, items:List<Any>) : MultiViewRecyclerViewBuilder {
        for(item in items) {
            this.items.add(MultiViewItem(viewHolderResourceId, item))
        }
        return this
    }

    fun addItems(items:List<Any>) : MultiViewRecyclerViewBuilder {
        for(item in items) {
            this.items.add(MultiViewItem(R.layout.default_string_list, item))
        }
        return this
    }

    fun then() : MultiViewRecyclerViewBuilder {
        return this
    }

    fun addClickListener(listener : MultiViewViewHolder.EventListener) {
        adapter.addEventListener(eventListener = listener)
    }

    fun setOrientation(isVertical : Boolean) {
        if(!isVertical) {
            orientation = RecyclerView.HORIZONTAL
        }
    }

    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager) {
        this.layoutManager = layoutManager
    }

    fun build() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = if(this.layoutManager != null) layoutManager else LinearLayoutManager(recyclerView.context, orientation, false)
    }
}