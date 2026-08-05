plugins {
    id("com.android.application")
    id("ly.img.android.sdk")
    id("com.google.devtools.ksp")
}

IMGLY.configure {

    pesdk {
        enabled(true)
        licencePath("pesdk_android_license")
    }

    // Define the modules you are need
    modules {
        include("ui:core")
        include("ui:text")
        include("ui:focus")
        include("ui:frame")
        include("ui:brush")
        include("ui:filter")
        include("ui:sticker")
        include("ui:overlay")
        include("ui:transform")
        include("ui:adjustment")
        include("ui:text-design")

        include("backend:serializer")
        include("backend:headless")

        include("assets:font-basic")
        include("assets:frame-basic")
        include("assets:filter-basic")
        include("assets:overlay-basic")
        include("assets:sticker-shapes")
        include("assets:sticker-emoticons")
        include("backend:sticker-smart")
    }
}

android {
    namespace = "com.photoeditorsdk.android.app"

    compileSdk = 35
    buildToolsVersion = "35.0.0"

    defaultConfig {
        applicationId = "com.photoeditorsdk.android.app"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            // Add this line to auto-sign release builds with debug keys for testing
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    lint {
        abortOnError = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.appcompat:appcompat:1.7.1")
}