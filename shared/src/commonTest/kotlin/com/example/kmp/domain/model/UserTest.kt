package com.example.kmp.domain.model

import kotlin.test.Test
import kotlin.test.assertEquals

class UserTest {

    @Test
    fun `fullName should return concatenated first and last name`() {
        val user = User(
            id = 1,
            firstName = "John",
            lastName = "Doe",
            age = 30,
            gender = "male",
            image = ""
        )

        assertEquals("John Doe", user.fullName)
    }
}