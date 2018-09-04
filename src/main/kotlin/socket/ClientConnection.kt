package main.kotlin.socket

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket
import java.net.SocketException

class ClientConnection(private val socket: Socket) : Thread() {
    private val input = socket.getInputStream()
    private val reader = BufferedReader(InputStreamReader(input))

    override fun run() {
        try {
            println("Processing connection")
            while (true) {
                val incoming: String = reader.readLine()
                this.processMessage(incoming)
            }
        } catch (error: SocketException) {
            println("Client has been disconnected, closing thread")
        } finally {
            SocketHandler.onDisconnect(socket.localSocketAddress)
            if (socket.isConnected) {
                socket.close()
            }
            this.join()
        }
    }

    private fun getPacket(incoming: String): Packet<EventPayload> =
            SocketHandler.gson.fromJson(incoming, Packet::class.java)

    private fun processMessage(string: String) {
        val packet: Packet<EventPayload> = getPacket(string)
        val event = packet.event
        println(packet.body)
        when (event) {
            Event.Ban -> {

            }
            else -> println("")
        }
    }
}