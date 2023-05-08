package com.azri.karma

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform