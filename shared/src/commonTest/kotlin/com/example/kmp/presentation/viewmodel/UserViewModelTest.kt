package com.example.kmp.presentation.viewmodel

import app.cash.turbine.test
import com.example.kmp.domain.model.User
import com.example.kmp.domain.usecase.GetUserUseCase
import com.example.kmp.fakes.FakeUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private val repository = FakeUserRepository()
    private val useCase = GetUserUseCase(repository)
    private lateinit var viewModel: UserViewModel
    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state should be Loading then Success`() = runTest {
        val user = User(6, "Olivia", "Wilson", 23, "female", "")
        repository.userToReturn = user
        
        viewModel = UserViewModel(useCase)

        viewModel.uiState.test {
            // Initial state from init block
            assertEquals(UserUiState.Loading, awaitItem())
            
            val successState = awaitItem()
            assertTrue(successState is UserUiState.Success)
            assertEquals(user, (successState as UserUiState.Success).user)
        }
    }

    @Test
    fun `should emit Error state when usecase fails`() = runTest {
        repository.shouldThrowError = true
        
        viewModel = UserViewModel(useCase)

        viewModel.uiState.test {
            assertEquals(UserUiState.Loading, awaitItem())
            
            val errorState = awaitItem()
            assertTrue(errorState is UserUiState.Error)
            assertEquals("Fake Error", (errorState as UserUiState.Error).message)
        }
    }
}