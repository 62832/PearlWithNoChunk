plugins {
    id("fabric-loom")
}

base.archivesName = "pearlwithnochunk-fabric"
version = "0.1"
group = "gripe.90"

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

loom {
    mods {
        create("pearlwithnochunk") {
            sourceSet(sourceSets.main.get())
        }
    }
}

repositories {
    maven {
        name = "ParchmentMC"
        url = uri("https://maven.parchmentmc.org")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.3")
    modImplementation("net.fabricmc:fabric-loader:0.16.10")

    @Suppress("UnstableApiUsage")
    mappings(loom.layered {
        officialMojangMappings()
        parchment("org.parchmentmc.data:parchment-1.21.3:2024.12.07@zip")
    })
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}
