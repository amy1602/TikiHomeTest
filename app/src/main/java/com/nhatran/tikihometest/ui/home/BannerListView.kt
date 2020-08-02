package com.nhatran.tikihometest.ui.home

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.nhatran.tikihometest.adapter.BannerListAdapter
import com.nhatran.tikihometest.domain.BannerData
import com.nhatran.tikihometest.domain.BannerItem
import com.nhatran.tikihometest.service.BannerApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        loadData()
    }

    fun loadData() {
        BannerApi.retrofitService.getBannerListAsync().enqueue(object : Callback<BannerData> {
            override fun onFailure(call: Call<BannerData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<BannerData>,
                response: Response<BannerData>
            ) {
                response.body()?.let { adapter.setData(it.data) }
            }

        })
    }
}