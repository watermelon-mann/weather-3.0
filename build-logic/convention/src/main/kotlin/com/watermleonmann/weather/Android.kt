package com.watermleonmann.weather

import AppConfig
import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureSdkVersions() = extensions.configure<BaseExtension> {
    setCompileSdkVersion(AppConfig.compileSdk)
    defaultConfig {
        targetSdk = AppConfig.targetSdk
        minSdk = AppConfig.minSdk
    }
}

fun Project.configureAndroidApplication() = extensions.configure<BaseExtension> {
    namespace = AppConfig.appNamespace
    defaultConfig {
        applicationId = AppConfig.applicationId
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {

        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}