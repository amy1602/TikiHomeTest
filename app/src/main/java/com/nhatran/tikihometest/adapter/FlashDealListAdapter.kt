package com.nhatran.tikihometest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nhatran.tikihometest.R
import com.nhatran.tikihometest.common.formatPriceToString
import com.nhatran.tikihometest.domain.FlashDealItem
import com.nhatran.tikihometest.ui.common.SaleStatusView

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

    fun setData(list: List<FlashDealItem>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivThumb: ImageView = itemView.findViewById(R.id.iv_thumb)
        var tvDiscount: TextView = itemView.findViewById(R.id.tv_discount)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        var statusView: SaleStatusView = itemView.findViewById(R.id.status_view)

        fun bindData(item: FlashDealItem) {
            Glide.with(itemView.context)
                .load(item.product?.thumbUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .into(ivThumb)

            tvDiscount.text = "-" + item.discountPercent + "%"
            tvPrice.text = item.product?.price?.let { formatPriceToString(it) }
            statusView.bindData(item.progress?.total!!, item.progress?.orderedNumber!!)
        }
    }
}