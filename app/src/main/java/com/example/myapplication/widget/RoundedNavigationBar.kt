package com.example.myapplication.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.view.WindowManager

/*
    Rounded Navigation Bar
 */
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
        val dPx = 0f    //start point axis X
        val dPy = 0.3f * mRect.bottom.toFloat() //start point axis Y
        val controlPx = 0.5f * mRect.right.toFloat()  
        val controlPy = -dPy
        mPath.moveTo(dPx, dPy)
        mPath.lineTo((0.30 * mRect.right).toFloat(), dPy)
        mPath.cubicTo(
            (0.40 * mRect.right).toFloat(),
            dPy,
            (0.43 * mRect.right).toFloat(),
            4f,
            controlPx,
            4f,
        )
        mPath.cubicTo(
            (0.57 * mRect.right).toFloat(),
            4f,
            (0.60 * mRect.right).toFloat(),
            dPy,
            (0.70 * mRect.right).toFloat(),
            dPy,
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
//        mPath.close()
        mPaint.strokeWidth = 1f
        mPaint.setShadowLayer(8f, 0f, -2f, 0xFF000000.toInt())
        mPaint.color = 0x33BDBDBD.toInt()
        mPaint.style = Paint.Style.STROKE
        canvas?.drawPath(mPath, mPaint)
    }


}