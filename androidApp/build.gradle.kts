plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hiltGradle)
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.9.21"
}

android {
    namespace = "com.ravikantsharma.translator_kmm.android"
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.ravikantsharma.translator_kmm"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.compileSdk.get().toInt()
        versionCode = libs.versions.appVersion.get().toInt()
        versionName = libs.versions.appVersionName.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.icons)
    implementation(libs.androidx.activity.compose)
    implementation(libs.ktor.client.android)
    implementation(libs.android.driver)
    implementation(libs.coilCompose)

    implementation(libs.hiltAndroid)
    implementation(libs.hiltNavigationCompose)
    kapt(libs.hiltAndroidCompiler)
//    kapt(libs.hiltCompiler)

    debugImplementation(libs.compose.ui.tooling)
}