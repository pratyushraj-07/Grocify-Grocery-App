package com.example.xmlpractice2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice2.R
import com.example.xmlpractice2.R.*
import com.example.xmlpractice2.model.Product

class CartAdapter(private val cartList: List<Product>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productImage = itemView.findViewById<ImageView>(id.productImage)

        val productName = itemView.findViewById<TextView>(id.productName)

        val productPrice = itemView.findViewById<TextView>(id.productPrice)

        val quantityText = itemView.findViewById<TextView>(id.txtQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(layout.item_cart, parent, false)

        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

        val product = cartList[position]

        holder.productImage.setImageResource(product.image)

        holder.productName.text = product.name

        holder.productPrice.text = "₹${product.price}"

        holder.quantityText.text = product.quantity.toString()
    }

    override fun getItemCount(): Int {

        return cartList.size
    }
}