import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.internal.dsl.BuildType
import com.android.builder.core.DefaultApiVersion
import com.android.builder.core.DefaultProductFlavor
import com.android.builder.model.ApiVersion

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

import org.jetbrains.kotlin.gradle.plugin.KotlinAndroidPluginWrapper

apply {
    plugin<AppPlugin>()
    plugin<KotlinAndroidPluginWrapper>()
}

android {
    buildToolsVersion("25.0.0")
    compileSdkVersion(25)

    defaultConfigExtension {
        setMinSdkVersion(15)
        setTargetSdkVersion(25)

        versionCode = 1
        versionName = "1.0"
    }

    buildTypesExtension {
        release {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {
    compile("com.android.support:appcompat-v7:25.0.1")
    compile(kotlinModule("stdlib"))
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:2.2.0")
        classpath(kotlinModule("gradle-plugin"))
    }

    repositories {
        jcenter()
        gradleScriptKotlin()
    }
}

/*
 * Extension functions to allow comfortable references
 * Taken from: https://github.com/gradle/gradle-script-kotlin/blob/master/samples/hello-android/build.gradle.kts
 */

fun Project.android(setup: AppExtension.() -> Unit) = the<AppExtension>().setup()

fun NamedDomainObjectContainer<BuildType>.release(setup: BuildType.() -> Unit) = findByName("release").setup()

fun AppExtension.defaultConfigExtension(setup: DefaultProductFlavor.() -> Unit) = defaultConfig.setup()

fun AppExtension.buildTypesExtension(setup: NamedDomainObjectContainer<BuildType>.() -> Unit) = buildTypes { it.setup() }

fun DefaultProductFlavor.setMinSdkVersion(value: Int) = setMinSdkVersion(value.asApiVersion())

fun DefaultProductFlavor.setTargetSdkVersion(value: Int) = setTargetSdkVersion(value.asApiVersion())

fun Int.asApiVersion(): ApiVersion = DefaultApiVersion.create(this)