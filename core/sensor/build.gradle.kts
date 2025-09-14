plugins {
    alias(libs.plugins.myapp.library)
    alias(libs.plugins.google.dagger.hilt)
    kotlin("kapt")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    // ----------------------------------------------------------------
    // Main Dependencies
    implementation(projects.core.common)

    implementation(libs.io.github.fwhyn.lib.baze)
    implementation(libs.org.apache.poi.ooxml)

    //// Dagger Hilt
    implementation(libs.bundles.dagger.hilt)
    kapt(libs.bundles.dagger.hilt.compiler)
    annotationProcessor(libs.bundles.dagger.hilt.compiler)

    // ----------------------------------------------------------------
    // Testing Dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}