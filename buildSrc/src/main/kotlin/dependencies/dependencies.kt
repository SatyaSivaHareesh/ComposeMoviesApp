object AppVersion {

    const val compileSdkVersion                 = 33
    const val minSdkVersion                     = 24
    const val targetSdkVersion                  = 32

    const val testInstrumentationRunner         = "androidx.test.runner.AndroidJUnitRunner"

    const val coreKtxVersion                    = "1.8.0"
    const val hiltVersion                       = "2.42"

    const val retrofitVersion                   = "2.9.0"
    const val retrofitOkhttpVersion             = "5.0.0-alpha.2"
    const val loggingInterceptorVersion         = "3.1.0"

    const val lifecycleVersion                  = "2.4.1"
    const val coroutinesVersion                 = "1.6.0"

    const val composeVersion                    = "1.2.0"
    const val composeMaterial3Version           = "1.0.0-alpha11"
    const val activityComposeVersion            = "1.5.1"
    const val navComposeVersion                 = "2.5.1"
    const val navHiltCompose                    = "1.0.0"
    const val coilVersion                       = "2.2.0"
    const val chuckerTeamLibraryVersion         = "3.5.2"
}

object AppDependencies {
    const val coreKtx                           = "androidx.core:core-ktx:${AppVersion.coreKtxVersion}"

    const val hilt                              = "com.google.dagger:hilt-android:${AppVersion.hiltVersion}"
    const val hiltCompiler                      = "com.google.dagger:hilt-android-compiler:${AppVersion.hiltVersion}"
    const val hiltNavCompose                    = "androidx.hilt:hilt-navigation-compose:${AppVersion.navHiltCompose}"

    const val retrofit                          = "com.squareup.retrofit2:retrofit:${AppVersion.retrofitVersion}"
    const val converterGson                     = "com.squareup.retrofit2:converter-gson:${AppVersion.retrofitVersion}"
    const val converterOkhttp                   = "com.squareup.okhttp3:okhttp:${AppVersion.retrofitOkhttpVersion}"
    const val loggingInterceptor                = "com.github.ihsanbal:LoggingInterceptor:${AppVersion.loggingInterceptorVersion}"

    const val lifecycleViewModel                = "androidx.lifecycle:lifecycle-viewmodel-ktx:${AppVersion.lifecycleVersion}"
    const val lifecycleLiveData                 = "androidx.lifecycle:lifecycle-livedata-ktx:${AppVersion.lifecycleVersion}"
    const val lifecycleRuntime                  = "androidx.lifecycle:lifecycle-runtime-ktx:${AppVersion.lifecycleVersion}"

    const val coroutinesCore                    = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${AppVersion.coroutinesVersion}"
    const val coroutinesAndroid                 = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${AppVersion.coroutinesVersion}"

    const val composeUI                         = "androidx.compose.ui:ui:${AppVersion.composeVersion}"
    const val composeMaterial                   = "androidx.compose.material3:material3:${AppVersion.composeMaterial3Version}"
    const val composeUIToolingPreview           = "androidx.compose.ui:ui-tooling-preview:${AppVersion.composeVersion}"
    const val activityCompose                   = "androidx.activity:activity-compose:${AppVersion.activityComposeVersion}"

    const val navCompose                        = "androidx.navigation:navigation-compose:${AppVersion.navComposeVersion}"

    const val coilCompose                       = "io.coil-kt:coil-compose:${AppVersion.coilVersion}"

    const val chuckerLibrary                    = "com.github.chuckerteam.chucker:library:${AppVersion.chuckerTeamLibraryVersion}"
    const val chuckerLibraryNoOp                = "com.github.chuckerteam.chucker:library-no-op:${AppVersion.chuckerTeamLibraryVersion}"

}

object TestVersion{
    const val junitVersion                      = "4.13.2"
    const val mockitoVersion                    = "4.3.1"
    const val mockitoKotlinVersion              = "4.0.0"
    const val extJUnitVersion                   = "1.1.3"
    const val espressoCoreVersion               = "3.4.0"
    const val kotlinCoroutinesTestVersion       = "1.3.2"
    const val robolectricVersion                = "4.7.3"
    const val coreKtxVersion                    = "1.4.0"
    const val junitKtxVersion                   = "1.1.3"
    const val archCoreTestVersion               = "2.1.0"
}

object TestDependencies{
    const val junit                             = "junit:junit:${TestVersion.junitVersion}"
    const val extJUnit                          = "androidx.test.ext:junit:${TestVersion.extJUnitVersion}"
    const val truth                             = "com.google.truth:truth:${TestVersion.extJUnitVersion}"

    const val extJUnitComposeUI                 = "androidx.compose.ui:ui-test-junit4:${AppVersion.composeVersion}"
    const val extComposeUITooling               = "androidx.compose.ui:ui-tooling:${AppVersion.composeVersion}"

    const val espressoCore                      = "androidx.test.espresso:espresso-core:${TestVersion.espressoCoreVersion}"

    const val mockitoInline                     = "org.mockito:mockito-inline:${TestVersion.mockitoVersion}"
    const val mockitoKotlin                     = "org.mockito.kotlin:mockito-kotlin:${TestVersion.mockitoKotlinVersion}"

    const val kotlinCoroutines                  = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestVersion.kotlinCoroutinesTestVersion}"

    const val robolectric                       = "org.robolectric:robolectric:${TestVersion.robolectricVersion}"

    const val coreKtx                           = "androidx.test:core-ktx:${TestVersion.coreKtxVersion}"
    const val junitKtx                          = "androidx.test.ext:junit-ktx:${TestVersion.junitKtxVersion}"
    const val archCore                          = "androidx.arch.core:core-testing:${TestVersion.archCoreTestVersion}"

}