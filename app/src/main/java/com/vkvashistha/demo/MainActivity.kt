package com.vkvashistha.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val baseViewHolderProvider =
            com.vkvashistha.multiviewrecyclerview.MultiViewViewHolderProvider()
        baseViewHolderProvider.registerViewHolderClass(R.layout.item_type1, ViewHolder1::class.java)
        baseViewHolderProvider.registerViewHolderClass(R.layout.item_type2, ViewHolder2::class.java)
        baseViewHolderProvider.registerViewHolderClass(R.layout.item_type3, ViewHolder3::class.java)

        // I wrote -1 as ViewType as positive integers are used above to represent layout ids.
        // But if you are only using Factory classes to instantiate then you can use any integer
        baseViewHolderProvider.registerViewHolderFactory(-1, ViewHolder3Factory (object : MyListener {
            override fun showToast(message: String) {
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
            }
        }))

        val _adapter =
            com.vkvashistha.multiviewrecyclerview.MultiViewRecyclerViewAdapter(
                baseViewHolderProvider
            )
        recyclerview.adapter = _adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        _adapter.submitList(getSampleItemList())
    }


    fun getSampleItemList() : ArrayList<com.vkvashistha.multiviewrecyclerview.MultiViewItem> {
        val list = ArrayList<com.vkvashistha.multiviewrecyclerview.MultiViewItem>()

        var count = 1
        while (count > 0) {
            list.add(
                com.vkvashistha.multiviewrecyclerview.MultiViewItem(
                    R.layout.item_type1,
                    Item1("Item1 Type")
                )
            )
            list.add(
                com.vkvashistha.multiviewrecyclerview.MultiViewItem(
                    R.layout.item_type2,
                    Item2(R.drawable.ic_launcher_background)
                )
            )
            list.add(
                com.vkvashistha.multiviewrecyclerview.MultiViewItem(
                    R.layout.item_type3,
                    Item3("Item type 3")
                )
            )
            count--
        }

        return list
    }

    interface MyListener {
        fun showToast(message :String)
    }
}
