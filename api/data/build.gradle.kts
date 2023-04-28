plugins {
    id("weather.android.library")
}

android {
    namespace = "com.watermelonmann.api.data"
}

dependencies {
    implementation(project(":shared:entity"))

    implementation(libs.kotlinx.coroutines.android)
}