package com.example.newsapplication.data.api

import com.example.newsapplication.data.models.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}