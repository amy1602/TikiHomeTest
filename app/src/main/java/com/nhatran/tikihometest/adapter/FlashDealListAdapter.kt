package com.nhatran.tikihometest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nhatran.tikihometest.R
import com.nhatran.tikihometest.domain.FlashDealItem

class FlashDealListAdapter : RecyclerView.Adapter<FlashDealListAdapter.ItemViewHolder>() {

    var itemList: ArrayList<FlashDealItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_flash_deal_item_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(itemList[position])
    }

    fun setData(list:ArrayList<FlashDealItem>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivThumb: ImageView = itemView.findViewById(R.id.iv_thumb)

        fun bindData(item: FlashDealItem) {
            Glide.with(itemView.context)
                .load(item.thumbUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(ivThumb)
        }
    }
}