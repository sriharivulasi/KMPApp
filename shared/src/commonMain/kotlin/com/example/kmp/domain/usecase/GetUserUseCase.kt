package com.example.kmp.domain.usecase

import com.example.kmp.domain.model.User
import com.example.kmp.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(id: Int): User {
        return repository.getUser(id)
    }
}