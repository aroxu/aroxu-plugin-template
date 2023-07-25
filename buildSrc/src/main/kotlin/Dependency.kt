object Dependency {
    object Kotlin {
        const val Version = "1.9.0"
    }

    object Paper {
        const val Version = "1.20.1"
        const val API = "1.20"
    }

    val repos = arrayListOf(
        "https://repo.papermc.io/repository/maven-public/"
    )

    object Libraries {
        val Lib = arrayListOf(
            "cloud.commandframework:cloud-paper:1.8.3",
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0",
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2",
            "com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:2.12.1",
            "com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:2.12.1"
        )

        val LibCore = arrayListOf(
            "cloud.commandframework:cloud-paper:1.8.3",
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0",
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2",
            "com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:2.12.1",
            "com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:2.12.1"
        )
    }
}
