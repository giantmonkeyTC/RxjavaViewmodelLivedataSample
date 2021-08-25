package com.example.myapplication.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class HomepageCombinationButton(context: Context, attributeset: AttributeSet) :
    ConstraintLayout(context, attributeset) {
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.layout_homepage_combination_button, this, true)
        val buttonIV = findViewById<ImageView>(R.id.combination_button_IV)
        val titleTV = findViewById<TextView>(R.id.combination_button_title_TV)
        val subtitleTV = findViewById<TextView>(R.id.combination_button_subtitle_TV)
        val attributeSet =
            context.obtainStyledAttributes(attributeset, R.styleable.HomepageCombinationButton)
        buttonIV.setImageDrawable(attributeSet.getDrawable(R.styleable.HomepageCombinationButton_button_src))
        titleTV.setText(attributeSet.getText(R.styleable.HomepageCombinationButton_title_text))
        titleTV.setTextColor(
            attributeSet.getColor(
                R.styleable.HomepageCombinationButton_title_text_color,
                0x000000
            )
        )
        titleTV.setTextSize(
            attributeSet.getDimension(
                R.styleable.HomepageCombinationButton_title_textSize,
                12f
            )
        )
        subtitleTV.setText(attributeSet.getText(R.styleable.HomepageCombinationButton_subtitle_text))
        subtitleTV.setTextColor(
            attributeSet.getColor(
                R.styleable.HomepageCombinationButton_subtitle_text_color,
                0x666666
            )
        )
        subtitleTV.setTextSize(
            attributeSet.getDimension(
                R.styleable.HomepageCombinationButton_subtitle_textSize,
                12f
            )
        )


    }

}