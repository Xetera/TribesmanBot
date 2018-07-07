package main.kotlin.net.xetera.listeners

import main.kotlin.net.xetera.Logger
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent

class PlayerListener : Listener {
    init {
        Logger.info("Listener initiated")
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent){
        Bukkit.broadcastMessage("${event.player.displayName} has joined the game!")
    }

    @EventHandler
    fun onPlayerChat(event: AsyncPlayerChatEvent){
        Bukkit.broadcastMessage(event.message)
    }

}