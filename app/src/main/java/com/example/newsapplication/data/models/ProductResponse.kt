package com.example.newsapplication.data.models

data class ProductResponse(
    val products: List<Product>, val total: Int, val skip: Int, val limit: Int
)

data class Dimensions(
    val width: Double, val height: Double, val depth: Double
)

data class Reviews(
    val rating: Int,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String,
)

data class Meta(
    val createdAt: String,
    val updatedAt: String,
    val barcode: String,
    val qrcode: String,
)

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: List<String>,
    val brand: String,
    val sku: String,
    val weight: Int,
    val dimensions: Dimensions,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<Reviews>,
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val meta: Meta,
    val thumbnail: String,
    val images: List<String>
)
