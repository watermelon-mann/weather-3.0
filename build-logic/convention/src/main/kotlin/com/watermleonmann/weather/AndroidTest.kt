package com.watermleonmann.weather

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureTest() {
    configurations.configureEach {
        resolutionStrategy {
            force(libs.findLibrary("junit4").get())
            // Temporary workaround for https://issuetracker.google.com/174733673
            force("org.objenesis:objenesis:2.6")
        }
    }
    dependencies {
        withLibs {
            "testImplementation"(get("junit4"))
            "androidTestImplementation"(get("androidx.test.espresso.core"))
            "androidTestImplementation"(get("androidx.test.ext"))
        }
    }
}