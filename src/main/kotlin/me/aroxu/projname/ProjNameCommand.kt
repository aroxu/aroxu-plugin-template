package me.aroxu.projname

import io.github.monun.kommand.node.RootNode
import net.kyori.adventure.text.Component.text

/**
 * @author aroxu
 */

object ProjNameCommand {
    fun register(builder: RootNode) {
        builder.apply {
            then("about") { executes { sender.sendMessage(text("ProjName by aroxu.")) } }
        }
    }
}
