plugins {
    id("weather.android.library")
    id("weather.compose.android.library")
    id("weather.android.hilt")
}

android {
    namespace = "com.watermelonmann.ui"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.material.design)
}