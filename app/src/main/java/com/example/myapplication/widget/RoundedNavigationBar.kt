package com.example.myapplication.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.view.WindowManager

class RoundedNavigationBar(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    var mPaint: Paint = Paint()
    var mPath: Path = Path()
    var mRect: Rect = Rect()
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(
            MeasureSpec.getSize(widthMeasureSpec),
            (0.1 * MeasureSpec.getSize(heightMeasureSpec)).toInt()
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mRect.top = 0
        mRect.left = 0
        mRect.bottom = height
        mRect.right = width
        val dPx = 0f
        val dPy = 0.3f * mRect.bottom.toFloat()
        val controlPx = 0.5f * mRect.right.toFloat()
        val controlPy = -dPy
        mPath.moveTo(dPx, 0f)
        mPath.lineTo((0.40 * mRect.right).toFloat(), dPy)
        mPath.quadTo(
            controlPx,
            controlPy,
            (0.6 * mRect.right).toFloat(),
            dPy
        )
        mPath.lineTo(
            mRect.right.toFloat(),
            dPy
        )
        mPath.lineTo(
            mRect.right.toFloat(),
            mRect.bottom.toFloat()
        )
        mPath.lineTo(
            mRect.left.toFloat(),
            mRect.bottom.toFloat()
        )
        mPath.close()
        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawPath(mPath, mPaint)
    }


}