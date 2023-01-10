package com.example.ui_design_3_01.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ui_design_3_01.R
import kotlinx.android.synthetic.main.widget_text_horizal.view.*

class WidgetTextHorizal(context: Context,attr : AttributeSet) : LinearLayout(context,attr),OnClickListener {
    var myOnClickListener : OnClickListener? = null
    init {
        init()
        val a = context.obtainStyledAttributes(attr,R.styleable.widget_text_horizal_2)
        val lefttext = a.getText(R.styleable.widget_text_horizal_2_lefttext)
        txt_wg_first.text = lefttext
        val righttext = a.getText(R.styleable.widget_text_horizal_2_righttext)
        txt_wg_last.text = righttext
        val textsize = a.getDimension(R.styleable.widget_text_horizal_2_textsize,1f)
        txt_wg_first.textSize = textsize
        txt_wg_last.textSize = textsize
        val textColor = a.getColor(R.styleable.widget_text_horizal_2_textcolor,0)
        txt_wg_last.setTextColor(textColor)
        txt_wg_first.setTextColor(textColor)
        val leftStyle = a.getInt(R.styleable.widget_text_horizal_2_leftStyle,0)
        val rightStyle = a.getInt(R.styleable.widget_text_horizal_2_rightStyle,0)
        setTextStyle(txt_wg_last,rightStyle)
        setTextStyle(txt_wg_first,leftStyle)
        val leftAlign = a.getInt(R.styleable.widget_text_horizal_2_leftAlignment,0)
        val rightAlign = a.getInt(R.styleable.widget_text_horizal_2_rightAlignment,0)
        setAlign(txt_wg_last,rightAlign)
        setAlign(txt_wg_first,leftAlign)

    }
    fun init(){
        inflate(context,R.layout.widget_text_horizal,this)
        super.setOnClickListener(myOnClickListener)
    }

    fun setTextStyle(textView : TextView,index : Int){
        if(index == 0){
            textView.typeface = Typeface.DEFAULT
        }
        else{
            textView.typeface = Typeface.DEFAULT_BOLD
        }
    }
    fun setAlign(textView : TextView,index : Int){
        if(index == 0){
            textView.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        }
        else if(index == 1){
            textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
        else{
            textView.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}