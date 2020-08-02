package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class QuickLinkData(
    @field:Json(name = "data")
    var data: List<List<QuickLinkItem>>
)