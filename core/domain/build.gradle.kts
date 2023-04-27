plugins {
    id("weather.android.library")
    id("weather.android.hilt")
}

android {
    namespace = "com.watermelonmann.domain"
}

dependencies {
    implementation(project(":api:data"))
    implementation(project(":core:data"))
}