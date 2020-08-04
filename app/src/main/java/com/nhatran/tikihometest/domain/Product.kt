package com.nhatran.tikihometest.domain

import com.squareup.moshi.Json

data class Product(
    @field:Json(name = "name")
    var name:String,
    @field:Json(name = "price")
    var price: Long,
    @field:Json(name = "thumbnail_url")
    var thumbUrl:String
)