package com.example.newsapplication.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.data.api.RetrofitInstance
import com.example.newsapplication.data.models.Post
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts


    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                _posts.value = RetrofitInstance.api.getPosts()
            } catch (e: Exception){
                println("Error : ${e.message}")
            }
        }
    }
}