package com.example.xmlpractice2.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice2.R
import com.example.xmlpractice2.adapter.CategoryAdapter
import com.example.xmlpractice2.adapter.ProductAdapter
import com.example.xmlpractice2.model.Category
import com.example.xmlpractice2.model.Product

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cartButton = findViewById<Button>(R.id.cartButton)

        cartButton.setOnClickListener {

            startActivity(Intent(this, CartActivity::class.java))
        }


        val categoryRecyclerView = findViewById<RecyclerView>(R.id.categoryRecyclerView)
        val searchEditTxt = findViewById<EditText>(R.id.searchEditText)

        val categoryList = listOf(
            Category("Fruits"),
            Category("Vegetables"),
            Category("Snacks"),
            Category("Drinks"),
            Category("Dairy")
        )
        val categoryAdapter = CategoryAdapter(categoryList)

        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        categoryRecyclerView.adapter = categoryAdapter


        val productRecyclerView = findViewById<RecyclerView>(R.id.productRecyclerView)

        val productList = listOf(
            Product("Apple", 100, R.drawable.ic_launcher_background),
            Product("Potato",50,R.drawable.ic_launcher_background),
            Product("Milk", 50, R.drawable.ic_launcher_background),
            Product("Bread", 40, R.drawable.ic_launcher_background),
            Product("Banana", 60, R.drawable.ic_launcher_background),
            Product("Sprite", 40, R.drawable.ic_launcher_background),
            Product("RedBull", 120, R.drawable.ic_launcher_background),
            Product("Biscuit", 15, R.drawable.ic_launcher_background)
        )
        val productAdapter = ProductAdapter(productList)

        productRecyclerView.layoutManager =
            LinearLayoutManager(this)

        productRecyclerView.adapter = productAdapter


        searchEditTxt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredList = productList.filter {
                    it.name.contains(s.toString(), true)
                }
                productAdapter.updateList(filteredList)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        searchEditTxt.setOnEditorActionListener { _, _, _ ->

            searchEditTxt.clearFocus()

            false
        }

    }
}