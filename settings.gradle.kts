pluginManagement {
    repositories {
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }

        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("fabric-loom") version "1.9-SNAPSHOT"
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
