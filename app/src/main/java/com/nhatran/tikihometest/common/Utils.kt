package com.nhatran.tikihometest.common

import android.content.Context
import android.util.TypedValue
import java.text.DecimalFormat


fun dpToPx(dp: Float, context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics
    )
}

fun formatPriceToString(price: Long): String {
    val formatter = DecimalFormat("#.###")
    return formatter.format(price) + " ₫"
}