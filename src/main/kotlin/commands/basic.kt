package main.kotlin.commands

import main.kotlin.socket.ConnectionHandler
import me.aberrantfox.kjdautils.api.dsl.CommandSet
import me.aberrantfox.kjdautils.api.dsl.commands

@CommandSet
fun pingCommand() = commands {
    command("ping") {
        execute {
            it.respond("pong")
        }
    }
    command("send") {
        execute {
            it.respond("I tried sending something")

        }
    }
    command("connected") {
        execute {
            it.respond("Currently serving ${ConnectionHandler.count} Minecraft servers.")
        }
    }
}