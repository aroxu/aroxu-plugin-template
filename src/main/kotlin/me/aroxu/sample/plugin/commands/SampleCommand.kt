package me.aroxu.sample.plugin.commands

import cloud.commandframework.Command
import cloud.commandframework.paper.PaperCommandManager
import net.kyori.adventure.text.Component.text
import org.bukkit.command.CommandSender
object SampleCommand {
    fun registerCommand(commandManager: PaperCommandManager<CommandSender>): Command.Builder<CommandSender> {
        val builder = commandManager.commandBuilder("sample", { "A Sample command" }, "smp")
            .apply { rootBuilder ->
                rootBuilder.permission { sender -> sender.isOp }
            }.handler { ctx ->
                ctx.sender.sendMessage(text("Hello World!"))
            }

        return builder
    }
}
