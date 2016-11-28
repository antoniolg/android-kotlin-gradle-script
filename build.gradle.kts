buildscript {
    repositories {
        jcenter()
        gradleScriptKotlin()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:2.2.0")
        classpath(kotlinModule("gradle-plugin"))
    }
}

allprojects {
    repositories {
        jcenter()
        gradleScriptKotlin()
    }
}