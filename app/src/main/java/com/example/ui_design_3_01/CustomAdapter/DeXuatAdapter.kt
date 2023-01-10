package com.example.ui_design_3_01.CustomAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_design_3_01.Model.FoodModel
import com.example.ui_design_3_01.R

class DeXuatAdapter(val context : Context) : RecyclerView.Adapter<DeXuatAdapter.ViewHolder>() {
    lateinit var dataSet : ArrayList<FoodModel>
    fun setData(dataSet : ArrayList<FoodModel>){
        this.dataSet = dataSet
    }
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imv_dexuat_hinh : ImageView
        val txt_dexuat_name : TextView
        val txt_dexuat_cost : TextView
        init {
            imv_dexuat_hinh = view.findViewById(R.id.imv_dexuat_hinh)
            txt_dexuat_name = view.findViewById(R.id.txt_dexuat_name)
            txt_dexuat_cost = view.findViewById(R.id.txt_dexuat_cost)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dexuat,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_dexuat_cost.text = dataSet.get(position).costFood.toString()
        holder.txt_dexuat_name.text = dataSet.get(position).nameFood
        holder.imv_dexuat_hinh.setImageResource(dataSet.get(position).imageFood)
    }
}