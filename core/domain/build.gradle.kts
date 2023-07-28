plugins {
    id("weather.android.library")
    id("weather.android.hilt")
}

android {
    namespace = "com.watermelonmann.domain"
}

dependencies {
    implementation(project(":shared:common"))
    implementation(project(":shared:entity"))
    implementation(project(":api:data"))
    implementation(project(":core:data"))

    testImplementation(project(":shared:testing:data-mock"))
}