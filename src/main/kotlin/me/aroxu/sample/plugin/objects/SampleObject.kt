package me.aroxu.sample.plugin.objects

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

@Suppress("UNUSED", "MemberVisibilityCanBePrivate") // REMOVE SUPPRESS WHEN USING!
object SampleObject {
    val CUSTOM_ITEM_1 = ItemStack(Material.BRICK).apply {
        editMeta {
            it.setCustomModelData(100)
            it.itemName(text("Custom Item 1"))
            it.changeLore(listOf(text("This is a custom item!")))
        }
    }

    private fun ItemMeta.changeLore(lore: List<ComponentLike>) {
        lore(lore.map { it.asComponent().color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false) })
    }
}
