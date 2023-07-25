import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.*

plugins {
    idea
    kotlin("jvm") version Dependency.Kotlin.Version
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.1.0"
}

group = "me.aroxu"
version = "0.0.1"
val codeName = "sample"

repositories {
    mavenCentral()
    Dependency.repos.forEach { maven(it) }
}

dependencies {
    library(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:${Dependency.Paper.Version}-R0.1-SNAPSHOT")
    Dependency.Libraries.Lib.forEach { compileOnly(it) }
    Dependency.Libraries.LibCore.forEach { paperLibrary(it) }
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }
    jar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
        archiveVersion.set("")
    }
    runServer {
        minecraftVersion(Dependency.Paper.Version)
        jvmArgs = listOf("-Dcom.mojang.eula.agree=true")
    }
}

idea {
    module {
        excludeDirs.addAll(listOf(file("run"), file("out"), file(".idea")))
    }
}

paper {
    main = "${project.group}.${codeName}.plugin.${codeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}Plugin"
    loader = "${project.group}.${codeName}.plugin.loader.${codeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}PluginLoader"

    generateLibrariesJson = true
    foliaSupported = false

    apiVersion = Dependency.Paper.API
}