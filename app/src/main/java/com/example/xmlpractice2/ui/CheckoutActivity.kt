package com.example.xmlpractice2.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice2.CartManager
import com.example.xmlpractice2.R
import com.example.xmlpractice2.adapter.CartAdapter

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_checkout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val orderRecyclerView = findViewById<RecyclerView>(R.id.orderRecyclerView)
        orderRecyclerView.layoutManager = LinearLayoutManager(this)
        val cartAdapter = CartAdapter(CartManager.cartItems)
        orderRecyclerView.adapter = cartAdapter

        val orderIdText = findViewById<TextView>(R.id.orderIdText)
        val orderId = (1000..9999).random()
        orderIdText.text = "Order ID: #$orderId"

        val deliveryText = findViewById<TextView>(R.id.deliveryText)
        deliveryText.text = "Estimated Delivery: 25 mins"


        val totalPriceText = findViewById<TextView>(R.id.totalPriceText)
        var total = 0
        for(product in CartManager.cartItems){
            total += product.price * product.quantity
        }
        totalPriceText.text = "Total: ₹$total"

    }
}