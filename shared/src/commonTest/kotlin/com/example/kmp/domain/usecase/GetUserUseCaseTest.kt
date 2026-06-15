package com.example.kmp.domain.usecase

import com.example.kmp.fakes.FakeUserRepository
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetUserUseCaseTest {

    private val repository = FakeUserRepository()
    private val useCase = GetUserUseCase(repository)

    @Test
    fun `invoke should return user from repository`() = runTest {
        val userId = 6
        val result = useCase(userId)

        assertEquals(userId, result.id)
        assertEquals(userId, repository.lastIdRequested)
    }
}