plugins {
    id("weather.android.library")
}

android {
    namespace = "com.watermelonmann.domain"
}

dependencies {
    implementation(project(":shared:entity"))
    implementation(project(":feature:data"))
}