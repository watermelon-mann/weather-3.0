import com.android.build.api.dsl.LibraryBuildType
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.util.Properties

plugins {
    id("weather.android.library")
    id("weather.android.hilt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

val properties: Properties = gradleLocalProperties(rootDir)

android {
    namespace = "com.watermelonmann.data"

    buildTypes {
        debug {
            buildConfigFields()
        }
        release {
            buildConfigFields()
        }
    }
}

dependencies {
    implementation(project(":api:data"))
    implementation(project(":shared:common"))
    implementation(project(":shared:entity"))

    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlin.serialization.converter)
    implementation(libs.kotlinx.serialization.json)
}

fun LibraryBuildType.buildConfigFields() {
    buildConfigField("String", "CITIES_API_KEY", properties.getProperty("CITIES_API_KEY"))
    buildConfigField("String", "CITIES_BASE_URL", "\"https://api.api-ninjas.com/\"")
}