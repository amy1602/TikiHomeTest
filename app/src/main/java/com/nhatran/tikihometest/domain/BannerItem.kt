package com.nhatran.tikihometest.domain

import com.google.gson.annotations.SerializedName

data class BannerItem(
    @SerializedName("mobile_url")
    var thumbUrl: String,
    @SerializedName("title")
    var title: String
)