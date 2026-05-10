package com.example.xmlpractice2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice2.CartManager
import com.example.xmlpractice2.R
import com.example.xmlpractice2.adapter.CartAdapter

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cartRecyclerView = findViewById<RecyclerView>(R.id.cartRecyclerView)
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        val cartAdapter = CartAdapter(CartManager.cartItems)
        cartRecyclerView.adapter = cartAdapter


        val totalPriceText = findViewById<TextView>(R.id.totalPriceText)
        var total = 0
        for(product in CartManager.cartItems){

            total += product.price * product.quantity
        }
        totalPriceText.text = "Total: ₹$total"


        val checkoutButton = findViewById<Button>(R.id.checkoutButton)
        checkoutButton.setOnClickListener {
            Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

    }
}