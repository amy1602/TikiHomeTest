package com.nhatran.tikihometest.domain

class HomeItem {
    var type: Int = TYPE_UNKNOWN

    companion object {
            const val TYPE_UNKNOWN = -1
            const val TYPE_BANNER_LIST = 0
            const val TYPE_QUICK_LINK_HEADER = 1
            const val TYPE_QUICK_LINK_LIST = 2
            const val TYPE_FLASH_DEAL_HEADER = 3
            const val TYPE_FLASH_DEAL_LIST = 4
            const val TYPE_LOADING = 5
    }
}