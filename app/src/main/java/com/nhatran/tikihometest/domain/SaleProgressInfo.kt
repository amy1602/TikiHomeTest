package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class SaleProgressInfo(
    @field:Json(name = "qty")
    var total:Int = 0,
    @field:Json(name = "qty_ordered")
    var orderedNumber:Int = 0
)