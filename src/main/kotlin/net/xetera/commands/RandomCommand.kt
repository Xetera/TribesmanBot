package main.kotlin.net.xetera.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

object RandomCommand : CommandExecutor {
    val random = Random()
    
    private fun generateRandom(range: Int = 100): Int {
        return this.random.nextInt(range)
    }

    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            return false
        }

        val range = try {
            args?.get(0)?.toInt()
        } catch (err: NumberFormatException) {
            // if there's a format exception then it's for sure defined
            sender.sendMessage("'${args!![0]}' has to be a number")
            return false
        } catch (err: ArrayIndexOutOfBoundsException){
            100
        }

        val number: Int = generateRandom(range ?: 100)
        sender.sendMessage("You got a: $number")
        return true
    }
}