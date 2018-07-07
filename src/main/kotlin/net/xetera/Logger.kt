package main.kotlin.net.xetera

import java.util.logging.Logger

object Logger {
    private val _logger = Logger.getLogger("Plugin")

    fun info(text: String){
        _logger.info(text)
    }
}