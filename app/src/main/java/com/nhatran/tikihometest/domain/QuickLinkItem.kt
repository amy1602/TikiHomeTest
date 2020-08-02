package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class QuickLinkItem (
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "image_url")
    var thumbUrl: String
)