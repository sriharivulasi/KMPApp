package com.example.kmp.domain.repository

import com.example.kmp.domain.model.User

interface UserRepository {
    suspend fun getUser(id: Int): User
}