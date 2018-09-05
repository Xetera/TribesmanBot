package main.kotlin.socket

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.net.SocketException
import java.util.logging.Logger

class ClientConnection(private val socket: Socket) : Thread() {
    private val log: Logger = Logger.getLogger("TribesmanBot:ClientConnection")

    private val input = socket.getInputStream()
    private val output = socket.getOutputStream()

    private val reader = BufferedReader(InputStreamReader(input))
    private val writer = PrintWriter(output, true)

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
            ConnectionHandler.onDisconnect(socket.localSocketAddress)
            if (socket.isConnected) {
                socket.close()
            }
            this.join()
        }
    }

    private fun getPacket(incoming: String): Packet<AbstractPayload> =
            ConnectionHandler.gson.fromJson(incoming, Packet::class.java)

    private fun processMessage(string: String) {
        val packet: Packet<AbstractPayload> = getPacket(string)
        val event = packet.event
        println(packet.body)
        when (event) {
            Event.Ban -> {

            }
        }
    }

    fun send(packet: Packet<AbstractPayload>) {
        /**
         * Should encrypt communication here
         */
        val out: String = ConnectionHandler.gson.toJson(packet)
        writer.println(out)
        log.info("Sent a ${packet.event} event to client ${socket.remoteSocketAddress}")
    }
}