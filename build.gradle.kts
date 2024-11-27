plugins {
    id("net.neoforged.moddev")
}

base.archivesName = "pearlwithnochunk"
version = "0.1"
group = "gripe.90"

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

neoForge {
    version = "21.3.48-beta"

    parchment {
        minecraftVersion = "1.21"
        mappingsVersion = "2024.11.10"
    }

    mods {
        create("pearlwithnochunk") {
            sourceSet(sourceSets.main.get())
        }
    }

    runs {
        create("client") {
            client()
            gameDirectory = file("run")
        }
    }
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}
