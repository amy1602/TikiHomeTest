package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class BannerData (
    @field:Json(name = "data")
    var data: List<BannerItem>
)