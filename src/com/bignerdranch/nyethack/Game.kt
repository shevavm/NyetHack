package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    val player = Player("Madrigal")
    player.castFireball()

    var currentRoom: Room = TownSquare()//14.10
    println(currentRoom.description())
    println(currentRoom.load())
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}
