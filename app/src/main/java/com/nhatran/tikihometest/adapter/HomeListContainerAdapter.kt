package com.nhatran.tikihometest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhatran.tikihometest.R
import com.nhatran.tikihometest.domain.HomeItem
import com.nhatran.tikihometest.ui.home.BannerListView
import com.nhatran.tikihometest.ui.home.FlashDealListView
import com.nhatran.tikihometest.ui.home.QuickLinkListView

class HomeListContainerAdapter : RecyclerView.Adapter<HomeListContainerAdapter.ItemViewHolder>() {
    private var itemList: ArrayList<HomeItem> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var itemView: View
        when(viewType) {
            TYPE_ROW_BANNER_LIST -> {
                itemView = BannerListView(parent.context)
            }
            TYPE_ROW_QUICK_LINK_LIST -> {
                itemView = QuickLinkListView(parent.context)
            }
            TYPE_ROW_FLASH_DEAL_HEADER -> {
                itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_flash_deal_header, parent, false)
            }
            TYPE_ROW_FLASH_DEAL_LIST -> {
                itemView = FlashDealListView(parent.context)
            }
            else -> {
                itemView = View(parent.context)
            }
        }
        val layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        itemView.layoutParams = layoutParams
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        itemList[position].let {
            holder.bindData(it)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        when(item.type) {
            HomeItem.TYPE_BANNER_LIST -> return TYPE_ROW_BANNER_LIST
            HomeItem.TYPE_QUICK_LINK_HEADER -> return TYPE_ROW_QUICK_LINK_HEADER
            HomeItem.TYPE_QUICK_LINK_LIST -> return TYPE_ROW_QUICK_LINK_LIST
            HomeItem.TYPE_FLASH_DEAL_HEADER -> return TYPE_ROW_FLASH_DEAL_HEADER
            HomeItem.TYPE_FLASH_DEAL_LIST -> return TYPE_ROW_FLASH_DEAL_LIST
        }
        return TYPE_ROW_UNKNOWN
    }

    fun setData(list: ArrayList<HomeItem>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(homeItem: HomeItem) {}
    }

    companion object {
        const val TYPE_ROW_UNKNOWN = -1
        const val TYPE_ROW_BANNER_LIST = 0
        const val TYPE_ROW_QUICK_LINK_HEADER = 1
        const val TYPE_ROW_QUICK_LINK_LIST = 2
        const val TYPE_ROW_FLASH_DEAL_HEADER = 3
        const val TYPE_ROW_FLASH_DEAL_LIST = 4
        const val TYPE_ROW_LOADING = 5
    }
}