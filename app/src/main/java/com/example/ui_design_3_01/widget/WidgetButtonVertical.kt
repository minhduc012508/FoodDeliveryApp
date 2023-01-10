package com.example.ui_design_3_01.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import com.example.ui_design_3_01.R
import kotlinx.android.synthetic.main.widget_button_vertical.view.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class WidgetButtonVertical(context : Context,attr : AttributeSet) : LinearLayout(context,attr),OnClickListener{
    var myOnClickListener : OnClickListener? = null
    var lock : Lock? = null
    init {
        init()
        val a = context.obtainStyledAttributes(attr,R.styleable.widget_button_vertical)
        val img = a.getDrawable(R.styleable.widget_button_vertical_imgSrc)
        imv_icon.setImageDrawable(img)
        val text = a.getText(R.styleable.widget_button_vertical_text)
        txt_name.text = text
        val textColor = a.getColor(R.styleable.widget_button_vertical_textColor,0)
        txt_name.setTextColor(textColor)
        val topline = a.getColor(R.styleable.widget_button_vertical_lineColor,0)
        view_topline.setBackgroundColor(topline)
    }
    fun init(){
        inflate(context,R.layout.widget_button_vertical,this)
        this.lock = ReentrantLock()
        super.setOnClickListener(this)
    }

    fun setImageRsc(resID : Int){
        imv_icon.setImageResource(resID)
    }

    fun setTextColor(color : Int){
        txt_name.setTextColor(color)
    }

    fun setTopLineColor(color : Int){
        view_topline.setBackgroundColor(color)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        myOnClickListener = l
    }

    override fun onClick(v: View?) {
        try {
            lock!!.lock()
            if(myOnClickListener!=null){
                myOnClickListener!!.onClick(v)
            }
        }
        finally {
            lock!!.unlock()
        }
    }
}