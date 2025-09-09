plugins {
    id("com.android.application") version Versions.agpVersion apply false
    id("com.android.library") version Versions.agpVersion apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlinVersion apply false
    id("com.google.dagger.hilt.android") version Versions.hiltVersion apply false
    id("com.google.devtools.ksp") version Versions.ksp apply false   // <— alinhar!
}
