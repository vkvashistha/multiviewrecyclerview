package com.vkvashistha.multiviewrecyclerview

object MultiViewRecyclerViewHelper {
    fun wrapInMultiViewItem(viewHolderLayoutId : Int, content : List<Any?>) : List<MultiViewItem> {
        val wrapList = ArrayList<MultiViewItem>(content.size)
        for(item in content) {
            wrapList.add(MultiViewItem(viewHolderLayoutId, item))
        }
        return wrapList
    }
}