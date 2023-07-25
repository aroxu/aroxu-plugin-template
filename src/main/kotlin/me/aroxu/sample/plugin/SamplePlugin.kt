package me.aroxu.sample.plugin

import cloud.commandframework.execution.CommandExecutionCoordinator
import cloud.commandframework.paper.PaperCommandManager
import me.aroxu.sample.plugin.commands.SampleCommand
import me.aroxu.sample.plugin.events.SampleEvent
import org.bukkit.plugin.java.JavaPlugin
import java.util.function.Function

class SamplePlugin : JavaPlugin() {
    companion object {
        lateinit var instance: SamplePlugin
            private set
    }

    override fun onEnable() {
        instance = this

        server.pluginManager.registerEvents(SampleEvent, this)

        val commandManager = PaperCommandManager(
            this,
            CommandExecutionCoordinator.simpleCoordinator(),
            Function.identity(),
            Function.identity()
        )
        commandManager.command(SampleCommand.registerCommand(commandManager))
    }
}
