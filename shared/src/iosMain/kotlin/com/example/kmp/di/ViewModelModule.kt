package com.example.kmp.di

import com.example.kmp.presentation.viewmodel.UserViewModel
import com.example.kmp.domain.usecase.GetUserUseCase
import com.example.kmp.data.repository.UserRepositoryImpl


object ViewModelProvider {
    fun getUserViewModel(): UserViewModel {
        return UserViewModel(GetUserUseCase(UserRepositoryImpl()))
    }
}