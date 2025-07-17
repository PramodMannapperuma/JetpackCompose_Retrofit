package com.example.newsapplication.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.data.api.RetrofitInstance
import com.example.newsapplication.data.models.Product
import com.example.newsapplication.data.models.ProductResponse
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _products = mutableStateOf(
        ProductResponse(
            products = emptyList(),
            total = 0,
            skip = 0,
            limit = 0
        )
    )
    val products: State<ProductResponse> = _products

    private val _cartItems = mutableStateListOf<Product>()
    val cartItems: List<Product> get() = _cartItems

    fun addToCart(product: Product) {
        _cartItems.add(product)
    }


    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                _products.value = RetrofitInstance.api.getProducts()
            } catch (e: Exception){
                println("Errorr : ${e.message}")
            }
        }
    }
}