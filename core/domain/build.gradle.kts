plugins {
    id("weather.android.library")
}

android {
    namespace = "com.watermelonmann.domain"
}

dependencies {
    implementation(project(":api:data"))
    implementation(project(":core:data"))
}