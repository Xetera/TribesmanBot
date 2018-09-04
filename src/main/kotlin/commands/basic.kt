package main.kotlin.commands

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
            // SocketClient.send()
        }
    }
}