package main.kotlin.net.xetera

import main.kotlin.net.xetera.commands.RandomCommand
import main.kotlin.net.xetera.listeners.PlayerListener
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Application : JavaPlugin() {
    val listeners: Array<Listener> = Array(1, {
        PlayerListener()
    })

    val commands:Array<CommandExecutor> = Array(1, {
        RandomCommand
    })


    init {
        Logger.info("Something here")
    }

    override fun onEnable() {
        Logger.info("Plugin has started.")
        Logger.info("Adding listeners...")

        listeners.forEach {
            Bukkit.getServer().pluginManager.registerEvents(it, this)
        }
        this.commands.forEach {
            this.getCommand("random").executor = RandomCommand
        }
    }

    override fun onDisable() {
        Logger.info("Plugin has been stopped.")
    }
}
