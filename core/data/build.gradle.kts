plugins {
    id("weather.android.library")
}

android {
    namespace = "com.watermelonmann.data"
}

dependencies {
    implementation(project(":api:data"))
}