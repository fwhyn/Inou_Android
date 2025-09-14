plugins {
    alias(libs.plugins.myapp.library)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.jetbrains.kotlin.compose)
    kotlin("kapt")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // ----------------------------------------------------------------
    // Main Dependencies
    implementation(projects.core.common)
    implementation(projects.core.sensor)

    implementation(libs.io.github.fwhyn.lib.baze)

    //// Compose
    implementation(libs.bundles.androidx.compose)
    implementation(platform(libs.androidx.compose.bom))

    //// Dagger Hilt
    implementation(libs.bundles.dagger.hilt)
    kapt(libs.bundles.dagger.hilt.compiler)
    annotationProcessor(libs.bundles.dagger.hilt.compiler)

    // ----------------------------------------------------------------
    // Testing Dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}