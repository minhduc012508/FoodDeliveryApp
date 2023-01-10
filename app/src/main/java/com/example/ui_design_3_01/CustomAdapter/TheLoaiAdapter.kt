package com.example.ui_design_3_01.CustomAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_design_3_01.Model.CategoryModel
import com.example.ui_design_3_01.R

class TheLoaiAdapter(val context: Context) : RecyclerView.Adapter<TheLoaiAdapter.ViewHolder>() {
    lateinit var dataSet : ArrayList<CategoryModel>

    fun setData(dataSet : ArrayList<CategoryModel>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView : TextView
        val imageView : ImageView
        init {
            textView = view.findViewById(R.id.txt_foodName)
            imageView = view.findViewById(R.id.imv_foodImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_theloai,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet.get(position).nameCate
        holder.imageView.setImageResource(dataSet.get(position).imageCate)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}