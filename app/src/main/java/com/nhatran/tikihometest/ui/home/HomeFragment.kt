package com.nhatran.tikihometest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nhatran.tikihometest.R
import com.nhatran.tikihometest.adapter.HomeListContainerAdapter
import com.nhatran.tikihometest.domain.HomeItem

class HomeFragment : Fragment() {
    private lateinit var rootView: View
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var rvListContainer: RecyclerView
    private lateinit var adapter: HomeListContainerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        swipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout)
        rvListContainer = rootView.findViewById(R.id.list_container)
        rvListContainer.layoutManager = LinearLayoutManager(context)
        adapter = HomeListContainerAdapter()
        rvListContainer.adapter = adapter
        setupData()
        return rootView
    }

    private fun setupData() {
        var itemList: ArrayList<HomeItem> = arrayListOf()
        var bannerItem = HomeItem()
        bannerItem.type = HomeItem.TYPE_BANNER_LIST

        var quickLinkItem = HomeItem()
        quickLinkItem.type = HomeItem.TYPE_QUICK_LINK_LIST

        var flashDealHeader = HomeItem()
        flashDealHeader.type = HomeItem.TYPE_FLASH_DEAL_HEADER

        var flashDealList = HomeItem()
        flashDealList.type = HomeItem.TYPE_FLASH_DEAL_LIST

        itemList.add(bannerItem)
        itemList.add(quickLinkItem)
        itemList.add(flashDealHeader)
        itemList.add(flashDealList)

        adapter.setData(itemList)
    }
}