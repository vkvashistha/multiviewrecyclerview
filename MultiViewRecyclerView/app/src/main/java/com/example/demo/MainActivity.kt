package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multirecyclerview.MultiViewItem
import com.example.multirecyclerview.MultiViewRecyclerViewAdapter
import com.example.multirecyclerview.MultiViewViewHolderProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseViewHolderProvider =
            MultiViewViewHolderProvider()
        baseViewHolderProvider.registerViewHolderClass(R.layout.item_type1, ViewHolder1::class.java)
        baseViewHolderProvider.registerViewHolderClass(R.layout.item_type2, ViewHolder2::class.java)
        baseViewHolderProvider.registerViewHolderClass(R.layout.item_type3, ViewHolder3::class.java)

        val _adapter =
            MultiViewRecyclerViewAdapter(
                baseViewHolderProvider
            )
        recyclerview.adapter = _adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        _adapter.submitList(getSampleItemList())
    }


    fun getSampleItemList() : ArrayList<MultiViewItem> {
        val list = ArrayList<MultiViewItem>()

        var count = 1
        while (count > 0) {
            list.add(
                MultiViewItem(
                    R.layout.item_type1,
                    Item1("Item1 Type")
                )
            )
            list.add(
                MultiViewItem(
                    R.layout.item_type2,
                    Item2(R.drawable.ic_launcher_background)
                )
            )
            list.add(
                MultiViewItem(
                    R.layout.item_type3,
                    Item3("Item type 3")
                )
            )
            count--
        }

        return list
    }
}
