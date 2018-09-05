package main.kotlin.socket

import com.google.common.collect.ImmutableList
import com.google.gson.Gson
import java.net.*
import javax.net.ssl.SSLServerSocketFactory

object ConnectionHandler {
    val gson = Gson()

    private val sock: ServerSocket =
            SSLServerSocketFactory.getDefault().createServerSocket(443)
    /**
     * Mutability only inside the handler itself
     */
    private var connections = mutableMapOf<SocketAddress, ClientConnection>()

    val clients: Array<ClientConnection> = this.connections.values.toTypedArray()
    val count: Int = this.connections.size

    fun poll() {
        while (true) {
            val conn = sock.accept()
            println("got new connection")
            val connection = ClientConnection(conn)
            connections[conn.remoteSocketAddress] = connection
            connection.start()
        }
    }

    fun onDisconnect(address: SocketAddress) {
        connections.remove(address)
    }

    fun broadcast(message: String){
        val payload = Message(message)
        val packet = Packet(Event.Broadcast,
                payload, "_som id", "token")

        clients.forEach {
            it.send(packet)
        }
    }


}


