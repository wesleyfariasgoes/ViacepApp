plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.wfghc.viacepapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.wfghc.viacepapp"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.7.0")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}")
    implementation ("com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}")

    // OKHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:${Versions.okhttpVersion}"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Dagger hilt
    implementation ("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    implementation ("androidx.navigation:navigation-fragment:2.5.3")
    kapt ("com.google.dagger:hilt-compiler:${Versions.hiltVersion}")

    //Room
    implementation ("androidx.room:room-ktx:${Versions.roomVersion}")
    implementation ("androidx.room:room-runtime:${Versions.roomVersion}")
    kapt ("androidx.room:room-compiler:${Versions.roomVersion}")

    // Navigation
    implementation ("androidx.fragment:fragment-ktx:1.5.5")

    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}")

    // Test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}