package com.nhatran.tikihometest.ui.home

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nhatran.tikihometest.adapter.FlashDealListAdapter
import com.nhatran.tikihometest.domain.FlashDealData
import com.nhatran.tikihometest.domain.FlashDealItem
import com.nhatran.tikihometest.service.FlashDealApi
import com.nhatran.tikihometest.service.FlashDealApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlashDealListView(context: Context) : RecyclerView(context) {
    init {
        initView()
    }

    private fun initView() {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = FlashDealListAdapter()

       loadData()
    }

    fun loadData() {
        FlashDealApi.flashDealRetrofitService.getFlashDealData().enqueue(object : Callback<FlashDealData> {
            override fun onFailure(call: Call<FlashDealData>, t: Throwable) {
                Log.d("aaaaaaaaa", "onFailure: ")
            }

            override fun onResponse(call: Call<FlashDealData>, response: Response<FlashDealData>) {
                Log.d("aaaaaaaaa", "onResponse: " + response.body())
                response.body()?.flashDealList?.let { (adapter as FlashDealListAdapter).setData(it) }
            }

        })
    }
}