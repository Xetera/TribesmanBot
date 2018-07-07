package main.kotlin.net.xetera.listeners

import main.kotlin.net.xetera.Logger
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerListener : Listener {
    init {
        Logger.info("Listener initiated")
    }
    @EventHandler
    public fun onPlayerJoin(event: PlayerJoinEvent){
        Bukkit.broadcastMessage("${event.player.displayName} has joined the game!")
    }
}