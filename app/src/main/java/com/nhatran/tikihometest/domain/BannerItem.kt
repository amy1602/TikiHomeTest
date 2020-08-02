package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class BannerItem(
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "mobile_url")
    var thumbUrl: String
)