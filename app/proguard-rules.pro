# Regla básica para conservar clases de Jetpack Compose
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# Conservar clases de Kotlin
-keep class kotlin.** { *; }
-dontwarn kotlin.**

# Conservar clases de Material Design 3
-keep class androidx.material3.** { *; }
-dontwarn androidx.material3.**

# Conservar clases de Lifecycle y ViewModel
-keep class androidx.lifecycle.** { *; }
-dontwarn androidx.lifecycle.**

# Conservar clases de Navigation Component si lo usas
-keep class androidx.navigation.** { *; }
-dontwarn androidx.navigation.**

# Evitar advertencias de otras librerías relacionadas
-dontwarn androidx.recyclerview.widget.RecyclerView
-dontwarn android.webkit.WebView
-dontwarn androidx.annotation.Nullable
-dontwarn androidx.legacy.widget.Space

# Evitar eliminación de clases utilizadas en reflexión (si usas Glide o similar)
-keep class com.bumptech.glide.** { *; }
-dontwarn com.bumptech.glide.**

# Evitar problemas de clases para bibliotecas HTTP como Volley o Retrofit
-keep class com.android.volley.** { *; }
-dontwarn com.android.volley.**
