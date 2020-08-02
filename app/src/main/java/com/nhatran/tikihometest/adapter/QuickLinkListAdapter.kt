package com.nhatran.tikihometest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nhatran.tikihometest.R
import com.nhatran.tikihometest.domain.QuickLinkItem

class QuickLinkListAdapter : RecyclerView.Adapter<QuickLinkListAdapter.ItemViewHolder>() {

    var itemList: ArrayList<QuickLinkItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_quick_link_item_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(itemList[position])
    }

    fun setData(list: List<QuickLinkItem>) {
        Log.d("asasasda", "setData: " + list)
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivThumb: ImageView = itemView.findViewById(R.id.iv_thumb)
        var tvTitle: TextView? = null

        init {
            tvTitle = itemView.findViewById(R.id.tv_title)
        }

        fun bindData(item: QuickLinkItem) {
            tvTitle?.text = item.title
            Glide.with(itemView.context)
                .load(item.thumbUrl)
                .placeholder(R.drawable.ic_placeholder)
                .centerCrop()
                .into(ivThumb)
        }
    }
}