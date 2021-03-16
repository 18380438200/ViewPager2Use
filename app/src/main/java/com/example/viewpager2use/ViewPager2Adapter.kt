package com.example.viewpager2use

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


/**
 * create by libo
 * create on 2021/3/16
 * description
 */
class ViewPager2Adapter(val context: Context): RecyclerView.Adapter<ViewPager2Adapter.ViewHolder>() {
    var layoutInflater: LayoutInflater? = null

    init {
        layoutInflater = LayoutInflater.from(context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivCover: ImageView? = null
        init {
            ivCover = itemView.findViewById(R.id.ivCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = layoutInflater!!.inflate(R.layout.item_page, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivCover?.background = context.resources.getDrawable(R.mipmap.page1)
    }

    override fun getItemCount() = 3

}