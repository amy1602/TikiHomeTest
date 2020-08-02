package com.nhatran.tikihometest.ui

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class TabItemView(context: Context, var icon: Int, var title: String) : LinearLayout(context) {
    private var titleTextView : TextView? = null
    private var iconImageView : ImageView? = null
    init {
        initView()
    }

    private fun initView() {
        orientation = VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL

        iconImageView = ImageView(context).apply {
            setImageResource(icon)
        }
        addView(iconImageView)

        titleTextView = TextView(context).apply {
            text = title
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
            gravity = Gravity.CENTER
            setTextColor(Color.parseColor(UNSELECTED_COLOR))
        }
        addView(titleTextView)
    }

    fun onTabSelected() {
        val color = Color.parseColor(SELECTED_COLOR)
        titleTextView?.setTextColor(color)
        iconImageView?.setColorFilter(color)
    }

    fun onTabUnselected() {
        val color = Color.parseColor(UNSELECTED_COLOR)
        titleTextView?.setTextColor(color)
        iconImageView?.setColorFilter(color)
    }

    companion object {
        const val SELECTED_COLOR = "#1565C0"
        const val UNSELECTED_COLOR = "#3F3F3F"

    }
}