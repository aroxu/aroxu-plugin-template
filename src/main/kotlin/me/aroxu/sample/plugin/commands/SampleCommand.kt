package me.aroxu.sample.plugin.commands

import cloud.commandframework.paper.PaperCommandManager
import net.kyori.adventure.text.Component.text
import org.bukkit.command.CommandSender

object SampleCommand {
    fun registerCommand(manager: PaperCommandManager<CommandSender>) {
        val rootBuilder = manager.commandBuilder("sample", { "A Sample command" }, "smp").apply { rootBuilder ->
                rootBuilder.permission { sender -> sender.isOp }
            }

        manager.command(rootBuilder.handler { ctx ->
            ctx.sender.sendMessage(text("Hello World!"))
        })
    }
}
