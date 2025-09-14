import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("com.android.library")
        target.plugins.apply("org.jetbrains.kotlin.android")

        target.extensions.configure(LibraryExtension::class.java) {
            compileSdk = AndroidConfig.COMPILE_SDK

            defaultConfig {
                minSdk = AndroidConfig.MIN_SDK
                testOptions.targetSdk = AndroidConfig.TARGET_SDK
            }

            flavorDimensions += "default"
            productFlavors {
                create("real") {
                    dimension = "default"
                }

                create("fake") {
                    dimension = "default"
                }
            }

            namespace = AndroidConfig.moduleNamespace(target.path)

            compileOptions {
                sourceCompatibility = AndroidConfig.javaVersion
                targetCompatibility = AndroidConfig.javaVersion
            }
        }

        target.extensions.configure(org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension::class.java) {
            compilerOptions {
                jvmTarget.set(AndroidConfig.jvmTarget)
            }
        }
    }
}