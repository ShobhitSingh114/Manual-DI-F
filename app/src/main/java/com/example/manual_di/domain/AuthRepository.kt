package com.example.manual_di.domain

interface AuthRepository {
    suspend fun login(email: String, password: String)
}