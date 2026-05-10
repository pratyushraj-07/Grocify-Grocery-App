package com.example.xmlpractice2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice2.R
import com.example.xmlpractice2.model.Category

class CategoryAdapter (
    private val categoryList: List<Category>
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    class CategoryViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]

        val textView = holder.itemView.findViewById<TextView>(R.id.categoryName)
        textView.text = category.name
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}