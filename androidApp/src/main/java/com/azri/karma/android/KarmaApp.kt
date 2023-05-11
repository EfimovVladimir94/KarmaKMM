package com.azri.karma.android

import PlatformSDK
import android.app.Application
import platform.PlatformConfiguration

class KarmaApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }
}

fun KarmaApp.initPlatformSdk() = PlatformSDK.init(
    configuration = PlatformConfiguration(androidContext = applicationContext)
)