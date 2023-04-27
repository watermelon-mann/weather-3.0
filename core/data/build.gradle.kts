plugins {
    id("weather.android.library")
    id("weather.android.hilt")
}

android {
    namespace = "com.watermelonmann.data"
}

dependencies {
    implementation(project(":api:data"))
}