import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
}

repositories {
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://repo.papermc.io/repository/maven-public/")
    mavenCentral()
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8:1.6.21"))
    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
    implementation("io.github.monun:kommand-api:2.12.0")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_16.toString()
    }

    create<Jar>("sourcesJar") {
        from(sourceSets["main"].allSource)
        archiveClassifier.set("sources")
    }

    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
    }
    
    register<Jar>("paperJar") {
        archiveBaseName.set("VirtualChest")
        from(sourceSets["main"].output)
        val pluginsDirectory = File(".server/plugins")
        val plugins = pluginsDirectory.listFiles { file: File -> file.isFile && file.name.endsWith(".jar") }
            ?: emptyArray()

        if (plugins.none { it.name.startsWith(archiveBaseName.get()) }) into(plugins)
        else {
            val updateDirectory = File(pluginsDirectory, "update")
            into(updateDirectory)
            doLast {
                File(updateDirectory, "UPDATE").createNewFile()
            }
        }
    }
}
