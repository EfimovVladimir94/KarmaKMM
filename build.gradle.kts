//plugins {
//    //trick: for the same plugin versions in all sub-modules
//    id("com.android.application").version("7.4.2").apply(false)
//    id("com.android.library").version("7.4.2").apply(false)
//    kotlin("android").version("1.8.0").apply(false)
//    kotlin("multiplatform").version("1.8.0").apply(false)
//}


buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("com.android.tools.build:gradle:7.4.2")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
