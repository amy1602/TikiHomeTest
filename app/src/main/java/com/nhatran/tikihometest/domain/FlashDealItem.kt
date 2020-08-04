package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class FlashDealItem(
    var thumbUrl: String,
    @field:Json(name = "discount_percent")
    var discountPercent: Int,
    @field:Json(name = "progress")
    var progress: SaleProgressInfo?,
    @field:Json(name = "product")
    var product: Product?
)