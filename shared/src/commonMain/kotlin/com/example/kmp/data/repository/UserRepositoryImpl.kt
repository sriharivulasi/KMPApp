package com.example.kmp.data.repository

import com.example.kmp.domain.model.User
import com.example.kmp.domain.repository.UserRepository
import com.example.kmp.data.network.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserRepositoryImpl : UserRepository {
    override suspend fun getUser(id: Int): User {
        return httpClient.get("https://dummyjson.com/users/$id").body()
    }
}