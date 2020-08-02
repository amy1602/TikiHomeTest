package com.nhatran.tikihometest.domain

import com.google.gson.annotations.SerializedName

data class BannerData (
    @SerializedName("data")
    var data: List<BannerItem>
)