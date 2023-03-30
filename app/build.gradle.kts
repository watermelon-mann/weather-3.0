plugins {
    id("weather.android.application")
}

dependencies {
    implementation(project(":feature:domain"))
    implementation(project(":feature:data"))
    implementation(project(":shared:entity"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material.design)
}