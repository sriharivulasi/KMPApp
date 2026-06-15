package com.example.kmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val gender: String,
    val image: String
) {
    val fullName: String get() = "$firstName $lastName"
}