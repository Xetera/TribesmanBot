package main.kotlin.socket

import java.util.*

enum class Event {
    Ban
}

interface EventPayload {

}

class Packet<out Body : EventPayload>(
        val event: Event,
        val body: Body,
        /**
         * This is going to be ID or the name of the person
         * running the command or the bot itself
         */
        val invoker: String?,
        val date: Date = Date()
)
