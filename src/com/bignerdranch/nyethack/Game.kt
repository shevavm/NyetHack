package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    val player = Player()
    player.castFireball()
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}


/*private fun auraColor(isBlessed: Boolean, healthPoint: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    /*3.8 покращення за допомогою умовного виразу
        if (auraVisible) {
        println("GREEN")
    }else{
        println("NONE")
    }*/
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

 12.4 4.6 private fun castFireball(numFireballs: Int=2) {
private fun castFireball (numFireballs: Int=2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")
//}
4.6 private fun formatHealthStatus(healthPoint: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoint) {*/
/*private fun formatHealthStatus(healthPoint: Int, isBlessed: Boolean) =
    when (healthPoint) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    //4.6 return healthStatus
//}*/ //12.18