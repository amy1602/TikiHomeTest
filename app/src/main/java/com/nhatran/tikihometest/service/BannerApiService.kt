package com.nhatran.tikihometest.service

import com.nhatran.tikihometest.domain.BannerData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.tiki.vn"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface BannerApiService {
    @GET("v2/home/banners/v2")
    fun getBannerListAsync() : Call<BannerData>
}

object BannerApi {
    val retrofitService : BannerApiService by lazy {
        retrofit.create(BannerApiService::class.java)
    }
}