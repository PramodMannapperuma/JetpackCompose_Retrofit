package com.example.newsapplication.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.data.api.RetrofitInstance
import com.example.newsapplication.data.models.LoginRequest
import com.example.newsapplication.data.models.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email
    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _errorMessage = mutableStateOf("")
    val errorMessage: State<String> = _errorMessage

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginResponse: State<LoginResponse?> = _loginResponse

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun login() {
        _isLoading.value = true
        _errorMessage.value = ""

        if(_email.value.isBlank() || _password.value.isBlank()) {
            _errorMessage.value = "Email and password are required"
            _isLoading.value = false
            return
        }

        viewModelScope.launch {
            try {
                _loginResponse.value = RetrofitInstance.api.login(
                    LoginRequest(username =  _email.value, password = _password.value)
                )
            } catch (e: Exception) {
                _errorMessage.value = "Login failed hutto: ${e.message}"
                println(e.message)
            } finally {
                _isLoading.value= false
            }
        }

    }
}