package com.nhatran.tikihometest.ui.home

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.nhatran.tikihometest.adapter.BannerListAdapter
import com.nhatran.tikihometest.domain.BannerItem


class BannerListView(context: Context) : FrameLayout(context) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: BannerListAdapter

    init {
        initView()
    }

    private fun initView() {
        recyclerView = RecyclerView(context)
        recyclerView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = BannerListAdapter()
        recyclerView.adapter = adapter
        addView(recyclerView)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        recyclerView.overScrollMode = View.OVER_SCROLL_NEVER

        var list: ArrayList<BannerItem> = arrayListOf()
        list.add(BannerItem("https://cdn.mos.cms.futurecdn.net/otjbibjaAbiifyN9uVaZyL.jpg"))
        list.add(BannerItem("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTqz0voSuESS3lMiVdmQC8917LynZH4v2HlsQ&usqp=CAU"))
        list.add(BannerItem("https://images.newindianexpress.com/uploads/user/imagelibrary/2020/4/23/w1200X800/animal-cat-face-close-up-feline-416160.jpg"))
        list.add(BannerItem("https://gimmeinfo.com/wp-content/uploads/2016/02/pets-cat-dog-2.jpg"))
        adapter.setData(list)
    }
}