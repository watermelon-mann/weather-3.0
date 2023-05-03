plugins {
    id("weather.android.library")
    id("weather.compose.android.library")
    id("weather.android.hilt")
}

android {
    namespace = "com.watermelonmann.cities"
}

dependencies {
    implementation(project(":shared:entity"))
    implementation(project(":shared:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
}