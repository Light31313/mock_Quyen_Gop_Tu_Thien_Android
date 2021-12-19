package com.vti.charityprojectmock11.view.detail.tabdetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vti.charityprojectmock11.R

class ViewPager2Adapter(
    private var images: List<String>,
    private var context:Context
) : RecyclerView.Adapter<ViewPager2Adapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.item_image_slider)

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_image_slider, p0, false)
        )
    }

    override fun onBindViewHolder(p0: Pager2ViewHolder, p1: Int) {
        //p0.itemImage.setImageResource(images[p1])
        Glide.with(context)
            .load(images[p1])
            .into(p0.itemImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}