// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.plugins.AppPlugin
import com.android.build.gradle.internal.plugins.LibraryPlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
plugins {
    id ("com.android.application") version "8.0.2" apply false
    id ("com.android.library") version "8.0.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.20" apply false
}
subprojects {
    plugins.matching { it is AppPlugin || it is LibraryPlugin }.whenPluginAdded {
        configure<BaseExtension> {
            compileSdkVersion(Consts.compileSdk)

            defaultConfig {
                minSdk = Consts.minSdk
                targetSdk = Consts.targetSdk
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            plugins.matching { it is KotlinAndroidProjectExtension}.whenPluginAdded{
                configure<KotlinAndroidProjectExtension> {
                    jvmToolchain(17)
                    sourceSets.all {
                        languageSettings {
                            languageVersion = "2.0"
                        }
                    }
                }
            }
        }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}