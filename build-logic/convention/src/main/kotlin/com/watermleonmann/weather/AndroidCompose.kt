/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.watermleonmann.weather

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {

    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.getVersion("androidxComposeCompiler").toString()
        }

        dependencies {
            withLibs {
                val bom = getLibrary("androidx-compose-bom")
                "implementation"(platform(bom))
                "implementation"(getLibrary("androidx-compose-navigation"))
                "implementation"(getLibrary("androidx-compose-material"))
                "implementation"(getLibrary("androidx-compose-tooling-preview"))
                "debugImplementation"(getLibrary("androidx-compose-tooling-debug"))
                "implementation"(getLibrary("androidx-compose-activity"))
                "implementation"(getLibrary("androidx-compose-lifecycle"))
                "implementation"(getLibrary("androidx-compose-viewModel"))
                "implementation"(getLibrary("hilt-compose-navigation"))
                "androidTestImplementation"(platform(bom))
            }
        }
    }
}

