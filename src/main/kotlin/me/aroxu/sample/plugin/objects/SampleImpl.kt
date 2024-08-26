package me.aroxu.sample.plugin.objects

import me.aroxu.sample.plugin.SamplePlugin

@Suppress("UNUSED", "MemberVisibilityCanBePrivate") // REMOVE SUPPRESS WHEN USING!
object SampleImpl {
    val plugin = SamplePlugin.instance
    val server = plugin.server
}
