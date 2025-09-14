plugins {
    alias(libs.plugins.myapp.application)
    alias(libs.plugins.jetbrains.kotlin.compose)
    alias(libs.plugins.google.dagger.hilt)
    kotlin("kapt")
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.fwhyn.app.inou.MyTestRunner"
    }

    buildTypes {
        release {
            // TODO isMinifyEnabled = false for temporary until proguard is fixed before public release
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    packaging {
        resources {
            excludes += listOf("META-INF/LICENSE-notice.md", "META-INF/LICENSE.md")
        }
    }
}

dependencies {
    // ----------------------------------------------------------------
    // Main Dependencies
    implementation(projects.feature.home)
    implementation(projects.core.common)
    implementation(projects.core.sensor)

    implementation(libs.androidx.core.splashscreen)
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
    testImplementation(libs.io.mock)
    testImplementation(libs.org.jetbrains.kotlinx.coroutines.test)
    testImplementation(libs.org.robolectric)
    testImplementation(libs.app.cash.turbine)
    testImplementation(libs.com.squareup.okhttp3.mockwebserver)

    androidTestImplementation(libs.androidx.test.runner)

    /// JUnit Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    //// Compose Testing
    androidTestImplementation(libs.bundles.androidx.compose.test)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    /// Dagger Hilt Testing
    testImplementation(libs.com.google.dagger.hilt.android.testing)
    kaptTest(libs.bundles.dagger.hilt.compiler)
    testAnnotationProcessor(libs.bundles.dagger.hilt.compiler)
    androidTestImplementation(libs.com.google.dagger.hilt.android.testing)
    kaptAndroidTest(libs.bundles.dagger.hilt.compiler)
    androidTestAnnotationProcessor(libs.bundles.dagger.hilt.compiler)
}