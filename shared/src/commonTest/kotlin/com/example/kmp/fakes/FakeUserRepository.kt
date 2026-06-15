package com.example.kmp.fakes

import com.example.kmp.domain.model.User
import com.example.kmp.domain.repository.UserRepository

class FakeUserRepository : UserRepository {
    var userToReturn: User? = null
    var shouldThrowError = false
    var lastIdRequested: Int? = null

    override suspend fun getUser(id: Int): User {
        lastIdRequested = id
        if (shouldThrowError) {
            throw Exception("Fake Error")
        }
        return userToReturn ?: User(id, "Fake", "User", 25, "Male", "")
    }
}