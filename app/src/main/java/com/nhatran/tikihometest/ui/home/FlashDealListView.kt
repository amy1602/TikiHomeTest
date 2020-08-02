package com.nhatran.tikihometest.ui.home

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhatran.tikihometest.adapter.FlashDealListAdapter
import com.nhatran.tikihometest.domain.FlashDealItem

class FlashDealListView(context: Context) : RecyclerView(context) {
    init {
        initView()
    }

    private fun initView() {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = FlashDealListAdapter()

        var list:ArrayList<FlashDealItem> = arrayListOf()
        list.add(FlashDealItem("https://www.washingtonian.com/wp-content/uploads/2019/02/milada-vigerova-1295750-unsplash-2048x3072.jpg"))
        list.add(FlashDealItem("https://image.shutterstock.com/image-photo/cute-kitten-baby-cat-260nw-781327003.jpg"))
        list.add(FlashDealItem("https://cdn.britannica.com/24/212324-050-076731DA/Persian-cat-sleeping.jpg"))
        list.add(FlashDealItem("https://static01.nyt.com/images/2019/09/04/business/04chinaclone-01/merlin_160087014_de761d9a-4360-402d-a15b-ddeff775760d-superJumbo.jpg"))
        list.add(FlashDealItem("https://static01.nyt.com/images/2019/09/04/business/04chinaclone-06/04chinaclone-06-jumbo.jpg"))

        (adapter as FlashDealListAdapter).setData(list)
    }
}