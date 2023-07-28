plugins {
    id("weather.android.library")
    id("weather.android.hilt")
}

android {
    namespace = "com.watermelonmann.data_mock"
}

dependencies {
    implementation(project(":api:data"))
    implementation(project(":shared:entity"))
}