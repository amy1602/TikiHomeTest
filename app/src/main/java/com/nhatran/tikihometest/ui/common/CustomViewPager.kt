package com.nhatran.tikihometest.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager : ViewPager {
    private var enableSwipeToScroll: Boolean = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs : AttributeSet) : super(context,attrs)

    fun setEnableSwipeToScroll(enable: Boolean) {
        enableSwipeToScroll = enable
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return enableSwipeToScroll && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return enableSwipeToScroll && super.onInterceptTouchEvent(ev)
    }
}