package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class FlashDealData(
    @field:Json(name = "data")
    var flashDealList: List<FlashDealItem>
)