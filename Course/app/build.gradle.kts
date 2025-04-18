plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.courseapp"
    compileSdk = 35 // Use a lower SDK if you encounter issues with SDK 35

    defaultConfig {
        applicationId = "com.example.courseapp"
        minSdk = 26 // Set to a more standard value
        targetSdk = 35 // You can update this to 35 later if needed
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core dependencies
    implementation(libs.androidx.core.ktx.v190) // Ensure the latest version
    implementation(libs.androidx.lifecycle.runtime.ktx.v251) // Check for the latest lifecycle version
    implementation(libs.androidx.activity.compose.v150) // Adjust for latest version

    // Material3 and Compose
    implementation(libs.material3) // Make sure you're using a valid version
    implementation(libs.androidx.material.icons.extended) // For icons

    // UI testing dependencies for Compose
    implementation(libs.ui) // Latest Compose version
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.mediation.test.suite) // For previewing Compose UIs

    // For testing with JUnit and Espresso
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4) // Compose testing library

    // Debugging dependencies
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    implementation(libs.play.services.ads)
}
