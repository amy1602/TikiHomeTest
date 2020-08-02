package com.nhatran.tikihometest.service

import com.nhatran.tikihometest.domain.QuickLinkData
import retrofit2.Call
import retrofit2.http.GET


interface QuickLinkApiService {
    @GET("shopping/v2/widgets/quick_link")
    fun getQuickLinkData() : Call<QuickLinkData>
}

object QuickLinkApi {
    val retrofitService: QuickLinkApiService by lazy {
        retrofit.create(QuickLinkApiService::class.java)
    }
}