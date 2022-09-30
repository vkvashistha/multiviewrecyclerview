package com.vkvashistha.multiviewrecyclerview

open class MultiViewItem (val reseId : Int, val content : Any?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MultiViewItem

        if (reseId != other.reseId) return false
        if (content != other.content) return false

        return true
    }

    override fun hashCode(): Int {
        var result = reseId
        result = 31 * result + (content?.hashCode() ?: 0)
        return result
    }
}