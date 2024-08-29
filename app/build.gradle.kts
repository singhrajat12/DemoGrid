plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id ("kotlin-kapt")
}

android {
    namespace = "com.example.dragondropapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dragondropapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {




    implementation ("androidx.recyclerview:recyclerview:1.3.2")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.room:room-runtime:2.6.1") // Room core
    kapt ("androidx.room:room-compiler:2.6.1") // Room annotation processor
    implementation ("androidx.room:room-ktx:2.6.1") // Room with Kotlin extensions
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")
    implementation ("com.google.android.exoplayer:exoplayer:2.19.1")




}