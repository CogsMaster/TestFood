package com.zkn.testfood.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.zkn.testfood.R

class CustomBlockAdapter(private val mList: List<ItemsViewModel2>) : RecyclerView.Adapter<CustomBlockAdapter.ViewHolder2>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_block, parent, false)
        return ViewHolder2(view)

    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {

        val ItemsViewModel2 = mList[position]

        // sets the image to the imageview from our itemHolder class



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder2(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

    }
}