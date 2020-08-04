package com.nhatran.tikihometest.ui.common

import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.util.AttributeSet
import android.view.View
import com.nhatran.tikihometest.R
import com.nhatran.tikihometest.common.dpToPx


class SaleStatusView : View {

    private lateinit var backgroundPaint: Paint
    private lateinit var salePaint: Paint
    private lateinit var textPaint: Paint
    private var displayText: String = context.getString(R.string.str_sale_start)
    private var total:Int = 2
    private var saleNumber:Int = 1

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        backgroundPaint = Paint().apply {
            color = Color.parseColor("#F5B7B1")
        }
        salePaint = Paint().apply {
            color = Color.parseColor("#EF5350")
        }
        textPaint = Paint().apply {
            color = Color.WHITE
            textSize = dpToPx(10f, context)
            style = Paint.Style.FILL
        }
    }

    fun bindData(total: Int, saleNumber: Int) {
        this.total = total
        this.saleNumber = saleNumber
        if (saleNumber == 0) {
            displayText = context.getString(R.string.str_sale_start)
        } else {
            displayText = context.getString(R.string.str_saled_number, saleNumber)
        }
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawBackground(canvas)
        drawSaleView(canvas)
        drawDisplayText(canvas)
    }

    private fun drawBackground(canvas: Canvas) {
        val corners = floatArrayOf(
            100f, 100f,   // Top left radius in px
            100f, 100f,   // Top right radius in px
            100f, 100f,     // Bottom right radius in px
            100f, 100f      // Bottom left radius in px
        )

        val path = Path()
        val rect = RectF(0f,0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rect, corners, Path.Direction.CW)
        canvas.drawPath(path, backgroundPaint)
    }

    private fun drawSaleView(canvas: Canvas) {
        val corners = floatArrayOf(
            100f, 100f,   // Top left radius in px
            100f, 100f,   // Top right radius in px
            100f, 100f,     // Bottom right radius in px
            100f, 100f      // Bottom left radius in px
        )

        val path = Path()
        var rect: RectF
        if (saleNumber == 0) {
            rect = RectF(0f,0f, height.toFloat(), height.toFloat())
        } else {
            rect = RectF(0f,0f, Math.max(width * saleNumber * 1f/ total, height.toFloat()), height.toFloat())
        }
        path.addRoundRect(rect, corners, Path.Direction.CW)
        canvas.drawPath(path, salePaint)
    }

    private fun drawDisplayText(canvas: Canvas) {
        val bounds = Rect()
        textPaint.getTextBounds(displayText, 0, displayText.length, bounds)
        val x = (width - bounds.width()) / 2
        val y = height / 2 + bounds.height() / 3
        canvas.drawText(displayText, x.toFloat(), y.toFloat(), textPaint)
    }
}