plugins {
    id("weather.android.library")
}

android {
    namespace = "com.watermelonmann.data"
}

dependencies {
    implementation(project(":shared:entity"))
}