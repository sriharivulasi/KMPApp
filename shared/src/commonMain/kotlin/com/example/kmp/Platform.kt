package com.example.kmp

interface Platform {
    val name: String
    val deviceName: String
}

expect fun getPlatform(): Platform