package main.kotlin.socket


import java.util.*

enum class Event {
        Ban, Broadcast
}

abstract class AbstractPayload

data class Message(val message: String) : AbstractPayload()

data class Heartbeat(val date: Date) : AbstractPayload()

data class BanEvent(val target: String) : AbstractPayload()

class Packet<out BodyType : AbstractPayload>(
        /**
         * Type of event, simple Enum
         */
        val event: Event,
        /**
         * Body of the event. Implemented as data
         * classes that inherit from [Payload] to
         * allow polymorphism
         */
        val body: BodyType,
        /**
         * ID of the invoker involved in the packet
         * Client ID is contained within the encrypted
         * JSON Web Token hash inside [token]
         */
        val _id: String,
        /**
         * Identity verification implemented as JWT
         * On server response, token is echo'd back
         */
        val token: String,
        /**
         * Date the packet was sent
         */
        val date: Date = Date()
)

