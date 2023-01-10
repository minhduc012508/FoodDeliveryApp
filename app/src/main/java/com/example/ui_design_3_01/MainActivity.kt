package com.example.ui_design_3_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.ui_design_3_01.Fragment.*
import com.example.ui_design_3_01.widget.WidgetButtonVertical
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {
    var trangthaifooter : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(FragmentHome(),"FragmentHome")
            }
        }
        setContentView(R.layout.activity_main)
        wg_home_home.setOnClickListener(this)
        wg_home_cart.setOnClickListener(this)
        wg_home_profile.setOnClickListener(this)
        wg_home_support.setOnClickListener(this)
        wg_home_setting.setOnClickListener(this)
    }
    fun resettrangthai(){
        when(trangthaifooter){
            0 -> {
                wg_home_home.setTextColor(ContextCompat.getColor(this,R.color.greyL))
                wg_home_home.setImageRsc(R.drawable.home)
                wg_home_home.setTopLineColor(ContextCompat.getColor(this,R.color.greyBackground))
            }
            1 -> {
                wg_home_profile.setTextColor(ContextCompat.getColor(this,R.color.greyL))
                wg_home_profile.setImageRsc(R.drawable.customer)
                wg_home_profile.setTopLineColor(ContextCompat.getColor(this,R.color.greyBackground))
            }
            2 -> {
                wg_home_cart.setTextColor(ContextCompat.getColor(this,R.color.greyL))
                wg_home_cart.setImageRsc(R.drawable.cast)
                wg_home_cart.setTopLineColor(ContextCompat.getColor(this,R.color.greyBackground))
            }
            3 -> {
                wg_home_support.setTextColor(ContextCompat.getColor(this,R.color.greyL))
                wg_home_support.setImageRsc(R.drawable.support)
                wg_home_support.setTopLineColor(ContextCompat.getColor(this,R.color.greyBackground))
            }
            4 -> {
                wg_home_setting.setTextColor(ContextCompat.getColor(this,R.color.greyL))
                wg_home_setting.setImageRsc(R.drawable.setting)
                wg_home_setting.setTopLineColor(ContextCompat.getColor(this,R.color.greyBackground))
            }
        }
    }

    fun widgetClick(view : WidgetButtonVertical,fragment : Fragment,resID : Int){
        resettrangthai()
        view.setTextColor(ContextCompat.getColor(this,R.color.yellow))
        view.setImageRsc(resID)
        view.setTopLineColor(ContextCompat.getColor(this,R.color.yellow))
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view,fragment)
        }
    }

    override fun onClick(v: View?) {
        var id = v!!.id
        when(id){
            R.id.wg_home_home -> {
                widgetClick(wg_home_home,FragmentHome(),R.drawable.home_yellow)
                trangthaifooter = 0

            }
            R.id.wg_home_profile -> {
                widgetClick(wg_home_profile,FragmentProfile(),R.drawable.custom_yellow)
                trangthaifooter = 1
            }
            R.id.wg_home_cart -> {
                widgetClick(wg_home_cart,FragmentCart(),R.drawable.cast_yellow)
                trangthaifooter = 2
            }
            R.id.wg_home_support -> {
                resettrangthai()
                widgetClick(wg_home_support,FragmentSupport(),R.drawable.support_yellow)
                trangthaifooter = 3
            }
            R.id.wg_home_setting -> {
                widgetClick(wg_home_setting,FragmentSetting(),R.drawable.setting_yellow)
                trangthaifooter = 4
            }
        }
    }
}