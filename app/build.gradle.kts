// build.gradle do módulo "app"
// Obs.: a partir do AGP 9 o suporte a Kotlin já vem embutido no plugin Android,
// por isso não é preciso aplicar o plugin "org.jetbrains.kotlin.android".
plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.receitas"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.receitas"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Habilita o ViewBinding: gera uma classe de binding para cada layout XML
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Apenas bibliotecas padrão do AndroidX / Material
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("com.google.android.material:material:1.13.0")
}
