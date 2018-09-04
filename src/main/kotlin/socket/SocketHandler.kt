package main.kotlin.socket

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketAddress
import java.net.SocketException

object SocketHandler {
    val gson = Gson()
    private val sock = ServerSocket(1234)
    private var connections = mutableMapOf<SocketAddress, Socket>()
    fun poll() {
        while (true) {
            val conn = sock.accept()
            println("got new connection")
            connections[conn.remoteSocketAddress] = conn
            ClientConnection(conn).start()
        }
    }

    fun onDisconnect(address: SocketAddress) {
        connections.remove(address)
    }
}


