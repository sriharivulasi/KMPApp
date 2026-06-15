package com.example.kmp

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val deviceName: String = UIDevice.currentDevice.name
}

actual fun getPlatform(): Platform = IOSPlatform()