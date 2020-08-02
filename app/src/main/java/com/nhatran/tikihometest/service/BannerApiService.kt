package com.nhatran.tikihometest.service

import com.nhatran.tikihometest.domain.BannerData
import retrofit2.Call
import retrofit2.http.GET

interface BannerApiService {
    @GET("v2/home/banners/v2")
        fun getBannerData() : Call<BannerData>
}

object BannerApi {
    val retrofitService : BannerApiService by lazy {
        retrofit.create(BannerApiService::class.java)
    }
}