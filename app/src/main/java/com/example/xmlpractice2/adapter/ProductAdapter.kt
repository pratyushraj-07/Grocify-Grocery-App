package com.example.xmlpractice2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice2.CartManager
import com.example.xmlpractice2.R
import com.example.xmlpractice2.model.Product

class ProductAdapter(
    private var productList : List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.productName)
        val price = itemView.findViewById<TextView>(R.id.productPrice)
        val image = itemView.findViewById<ImageView>(R.id.productImage)

        val plusButton = itemView.findViewById<Button>(R.id.plsBtn)
        val minusButton = itemView.findViewById<Button>(R.id.minusBtn)
        val quantityText = itemView.findViewById<TextView>(R.id.txtQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.name.text = product.name
        holder.price.text = "${product.price}"
        holder.image.setImageResource(product.image)

        holder.plusButton.setOnClickListener {
            product.quantity++
            holder.quantityText.text = product.quantity.toString()

            if (!CartManager.cartItems.contains(product)) {

                CartManager.cartItems.add(product)
            }

        }

        holder.minusButton.setOnClickListener {

            if (product.quantity > 0) {
                product.quantity--
                holder.quantityText.text = product.quantity.toString()

                if(product.quantity == 0){

                    CartManager.cartItems.remove(product)
                }
            }
        }
    }

    fun updateList(newList: List<Product>){
        productList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}