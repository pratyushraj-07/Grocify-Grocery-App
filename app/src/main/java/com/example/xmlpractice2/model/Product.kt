package com.example.xmlpractice2.model

data class Product(
    val name: String,
    val price: Int,
    val image: Int,
    var quantity: Int = 0
)