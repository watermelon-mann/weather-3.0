package com.watermleonmann.weather

import AppConfig
import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.BaseExtension
import com.android.build.api.dsl.BuildType
import org.gradle.api.NamedDomainObjectContainer
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
    }
}

fun CommonExtension<*, *, *, *>.configureBuildTypes(
    configuration: NamedDomainObjectContainer<out BuildType>.() -> Unit = {}
) {
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
        configuration()
    }
}