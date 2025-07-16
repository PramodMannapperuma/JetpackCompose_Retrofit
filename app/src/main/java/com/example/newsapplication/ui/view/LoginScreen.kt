package com.example.newsapplication.ui.view

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsapplication.Routes
import com.example.newsapplication.ui.view.home.CustomOutlinedTextField
import com.example.newsapplication.viewModel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel(),
) {
    val email by loginViewModel.email
    val password by loginViewModel.password
    val errorMessage by loginViewModel.errorMessage
    val isLoading by loginViewModel.isLoading
    val loginResponse by loginViewModel.loginResponse

    LaunchedEffect(loginResponse) {
        if (loginResponse != null) {
            navController.navigate(Routes.HomeScreen) {
                popUpTo("LoginScreen") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Login", style = MaterialTheme.typography.headlineMedium)

            CustomOutlinedTextField(
                value = email,
                onValueChange = { loginViewModel.onEmailChange(it) },
                label = "Email or Username",
                singleLine = true,
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )

            CustomOutlinedTextField(
                value = password,
                onValueChange = { loginViewModel.onPasswordChange(it) },
                label = "Password",
                singleLine = true,
                keyboardType = KeyboardType.Password,
                modifier = Modifier.fillMaxWidth()
            )

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Button(
                onClick = { loginViewModel.login() },
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(20.dp)
                    )
                } else {
                    Text("Login")
                }
            }
        }
    }
}
