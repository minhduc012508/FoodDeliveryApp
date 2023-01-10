package com.example.ui_design_3_01.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_design_3_01.CustomAdapter.DeXuatAdapter
import com.example.ui_design_3_01.CustomAdapter.TheLoaiAdapter
import com.example.ui_design_3_01.Model.CategoryModel
import com.example.ui_design_3_01.Model.FoodModel
import com.example.ui_design_3_01.R
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment() {
    lateinit var rcTheLoai : RecyclerView
    lateinit var rcDeXuat : RecyclerView
    var listCate : ArrayList<CategoryModel>? = null
    var theLoaiAdapter : TheLoaiAdapter? = null
    var listRecommend : ArrayList<FoodModel>? = null
    var deXuatAdapter : DeXuatAdapter? = null
    var txt_home_xinchao : TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)
        anhxa(view)
        setGreeting("Xin chào Ba Gà")
        return view
    }

    fun setGreeting(str : String){
        txt_home_xinchao!!.text = str
    }
    fun anhxa(view : View){
        txt_home_xinchao = view.findViewById(R.id.txt_home_xinchao)
        rcTheLoai = view.findViewById(R.id.rc_theloai)
        rcDeXuat = view.findViewById(R.id.rc_dexuat)

        setListCategory()
        setListRecommend()

        theLoaiAdapter = TheLoaiAdapter(view.context)
        theLoaiAdapter!!.setData(listCate!!)

        deXuatAdapter = DeXuatAdapter(view.context)
        deXuatAdapter!!.setData(listRecommend!!)

        rcTheLoai.layoutManager = LinearLayoutManager(view.context.applicationContext,RecyclerView.HORIZONTAL,false)
        rcTheLoai.adapter = theLoaiAdapter
        rcDeXuat.layoutManager = LinearLayoutManager(view.context.applicationContext,RecyclerView.HORIZONTAL,false)
        rcDeXuat.adapter = deXuatAdapter
    }
    fun setListRecommend(){
        listRecommend = ArrayList()
        listRecommend!!.add(FoodModel("Pizza 1",11.99f,R.drawable.pizza_1))
        listRecommend!!.add(FoodModel("Hamburger 1",20.99f,R.drawable.hamburguer_1))
        listRecommend!!.add(FoodModel("Milktea 1 1",5.99f,R.drawable.m))
        listRecommend!!.add(FoodModel("Pizza 1",11.99f,R.drawable.pizza_1))
        listRecommend!!.add(FoodModel("Hamburger 1",20.99f,R.drawable.hamburguer_1))
        listRecommend!!.add(FoodModel("Milktea 1 1",5.99f,R.drawable.m))
    }
    fun setListCategory(){
        listCate = ArrayList()
        listCate!!.add(CategoryModel("Pizza",R.drawable.pizza_50))
        listCate!!.add(CategoryModel("Milk",R.drawable.milk_50))
        listCate!!.add(CategoryModel("Pizza",R.drawable.pizza_50))
        listCate!!.add(CategoryModel("Milk",R.drawable.milk_50))
        listCate!!.add(CategoryModel("Pizza",R.drawable.pizza_50))
        listCate!!.add(CategoryModel("Milk",R.drawable.milk_50))
        listCate!!.add(CategoryModel("Pizza",R.drawable.pizza_50))
        listCate!!.add(CategoryModel("Milk",R.drawable.milk_50))
        listCate!!.add(CategoryModel("Pizza",R.drawable.pizza_50))
        listCate!!.add(CategoryModel("Milk",R.drawable.milk_50))
    }
}