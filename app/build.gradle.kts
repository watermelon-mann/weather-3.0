plugins {
    id("weather.android.application")
    id("weather.compose.android.application")
    id("weather.android.hilt")
}

dependencies {
    implementation(project(":shared:entity"))
    implementation(project(":core:ui"))

    implementation(project(":feature:cities"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material.design)
}