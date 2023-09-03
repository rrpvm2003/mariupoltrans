plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rrpvm.feature.home"
    buildFeatures {
        compose = true
    }
}

dependencies {
    val nav_version = "2.7.0"
    implementation("androidx.core:core-ktx:1.8.0")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.navigation:navigation-compose:$nav_version")



    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta01")
}