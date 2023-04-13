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
            add("testImplementation", get("junit4"))
            add("androidTestImplementation", get("androidx.test.espresso.core"))
            add("androidTestImplementation", get("androidx.test.ext"))
        }
    }
}