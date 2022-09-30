# MultiViewRecyclerView
A demo which shows how to support multiple views in Recycler View in more generic and cleaner way
Clients can simply put their variety of data items into Adapter, passing their ViewHolderClasses. MultiViewRecyclerViewAdapter will adutomatically handles different types of content.

!["MultiviewRecyclerView is holding 3 different types of ViewHolders"](/screenshot.png "MultiviewRecyclerView is holding 3 different types of ViewHolders").

In above screenshot, we have 3 different types of ViewHolders : (1) Holding a simple `TextView` , (2) Holding a simple `ImageView`, (3) Holding a `Button`
Read this article for more details :- https://medium.com/@vivekvashistha/clean-way-to-implement-multi-views-in-recycler-view-using-listadapter-4c49afa0da1

## Usage
Step 1 : Import the library
```
implementation 'com.github.vkvashistha:multiviewrecyclerview:1.0.1'
```

Step 2 : Create ViewHolder classes that extends MultiViewViewHolder. For e.g. ViewHolder1 can be implemented as follows:-
```
class ViewHolder1(itemView : View) : MultiViewViewHolder(itemView) {
    override fun onBindVewHolder(position: Int, multiViewItem: MultiViewItem) {
        super.onBindVewHolder(position, multiViewItem)
        val tv_text = itemView.findViewById<TextView>(R.id.tv_text)
        val item = multiViewItem.content as Item1
        tv_text.text =  item.text
    }
}
```
Step 3 : Register all ViewHolders alongwith their corresponding Layout files as follows:-
```
val viewHolderProvider =
com.vkvashistha.multiviewrecyclerview.MultiViewViewHolderProvider()
viewHolderProvider.registerViewHolderClass(R.layout.item_type1, ViewHolder1::class.java)
viewHolderProvider.registerViewHolderClass(R.layout.item_type2, ViewHolder2::class.java)
viewHolderProvider.registerViewHolderClass(R.layout.item_type3, ViewHolder3::class.java)
```
Step 4 : Setup Adapter
```
val _adapter = MultiViewRecyclerViewAdapter(viewHolderProvider)
recyclerview.adapter = _adapter
recyclerview.layoutManager = LinearLayoutManager(this)
```

Step 5 : Wrap List items alongwith ViewHolder information as follows:-
```
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
```

Step 6 : Submit wrapped list to adapter:-
```
_adapter.submitList(getSampleItemList())
```