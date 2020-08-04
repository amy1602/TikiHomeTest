package com.nhatran.tikihometest.service

import com.nhatran.tikihometest.domain.FlashDealData
import retrofit2.Call
import retrofit2.http.GET

interface FlashDealApiService {
    @GET("v2/widget/deals/hot")
    fun getFlashDealData(): Call<FlashDealData>
}

object FlashDealApi {
    val flashDealRetrofitService : FlashDealApiService by lazy {
        retrofit.create(FlashDealApiService::class.java)
    }
}