package com.nhatran.tikihometest.ui.home

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhatran.tikihometest.adapter.QuickLinkListAdapter
import com.nhatran.tikihometest.common.dpToPx
import com.nhatran.tikihometest.domain.QuickLinkData
import com.nhatran.tikihometest.domain.QuickLinkItem
import com.nhatran.tikihometest.service.QuickLinkApi
import com.nhatran.tikihometest.service.QuickLinkApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        loadData()
    }

    fun loadData() {
        QuickLinkApi.retrofitService.getQuickLinkData().enqueue(object : Callback<QuickLinkData> {
            override fun onFailure(call: Call<QuickLinkData>, t: Throwable) {
            }

            override fun onResponse(call: Call<QuickLinkData>, response: Response<QuickLinkData>) {
                response.body()?.let {
                    val quickLinkList:ArrayList<QuickLinkItem> = arrayListOf()
                    for (list in it.data) {
                        quickLinkList.addAll(list)
                    }
                    adapter.setData(quickLinkList)
                }
            }

        })
    }
}