plugins {
    id("weather.android.application")
    id("weather.android.hilt")
}

dependencies {
    implementation(project(":shared:entity"))
    implementation(project(":core:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material.design)
}