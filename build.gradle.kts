import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.20"
    kotlin("plugin.serialization") version "1.8.20"
}

repositories {
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://repo.papermc.io/repository/maven-public/")
    mavenCentral()
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("io.github.monun:kommand-api:3.1.3")
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
        archiveBaseName.set("ProjName")
        from(sourceSets["main"].output)
        val plugins = File(rootDir, ".server/plugins/")

        doLast {
            copy {
                from(archiveFile)
                if (File(plugins, archiveFileName.get()).exists()) {
                    File(plugins, archiveFileName.get()).delete()
                }
                into(plugins)
            }
        }
    }
}
