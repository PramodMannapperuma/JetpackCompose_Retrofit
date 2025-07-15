package com.example.newsapplication.data.api

import com.example.newsapplication.data.models.LoginRequest
import com.example.newsapplication.data.models.LoginResponse
import com.example.newsapplication.data.models.ProductResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest) : LoginResponse

    @GET("products")
    suspend fun getProducts(): ProductResponse
}