package com.nhatran.tikihometest.ui.home

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhatran.tikihometest.adapter.QuickLinkListAdapter
import com.nhatran.tikihometest.common.dpToPx
import com.nhatran.tikihometest.domain.QuickLinkItem

class QuickLinkListView(context: Context) : FrameLayout(context) {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: QuickLinkListAdapter
    private lateinit var layoutManager: GridLayoutManager

    init {
        initView()
    }

    private fun initView() {
        recyclerView = RecyclerView(context)
        val dp8 = dpToPx(8f, context).toInt()
        setPadding(dp8, dp8, dp8, dp8)
        recyclerView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        adapter = QuickLinkListAdapter()
        recyclerView.adapter = adapter
        addView(recyclerView)

        var list: ArrayList<QuickLinkItem> = arrayListOf()
        list.add(QuickLinkItem("https://images.pexels.com/photos/736230/pexels-photo-736230.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", "Max giam gia"))
        list.add(QuickLinkItem("https://leeflowerfarm.com/assets/images/lee-flower-home-cover-01-1920x1080.jpg", "Max giam gia sdsdf sdsdcdsc"))
        list.add(QuickLinkItem("https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg", "Max giam gi sfwdcc csds s"))
        list.add(QuickLinkItem("https://i.pinimg.com/originals/11/2b/74/112b746a2182417b2a947d949798c968.jpg", "4"))
        list.add(QuickLinkItem("https://cdn.pixabay.com/photo/2015/04/19/08/33/flower-729512__340.jpg", "5"))
        list.add(QuickLinkItem("https://static01.nyt.com/images/2020/05/10/realestate/01garden-flowers1/01garden-flowers1-videoSixteenByNineJumbo1600-v2.jpg", "6"))
        list.add(QuickLinkItem("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQDwK_iHqafBTLEb_ux_krwUBfD8Lkpcmuaaw&usqp=CAU", "Max giam gi"))
        list.add(QuickLinkItem("https://m.floweraura.com/sites/all/themes/blog/images/12-very-Unusual/1.jpg", "8"))
        list.add(QuickLinkItem("https://www.atozflowers.com/wp-content/uploads/2017/11/800px-Zinnienbl%C3%BCte_Zinnia_elegans_stack15_20190722-RM-7222254.jpg", "9"))
        adapter.setData(list)
    }
}