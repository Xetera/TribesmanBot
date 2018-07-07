package main.kotlin.net.xetera

import main.kotlin.net.xetera.listeners.PlayerListener
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Application : JavaPlugin() {
    var listeners: Array<Listener> = Array(1, { PlayerListener() })
    init {
        Logger.info("Something here")
    }
    override fun onEnable() {
        Logger.info("Plugin has started.")
        Logger.info("Adding listeners...")

        listeners.forEach {
            Bukkit.getServer().pluginManager.registerEvents(it, this)
        }


    }
}
