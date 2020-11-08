package com.bignerdranch.nyethack


class Player {
    var name: String = "madrigal"
        //12.5//12.10
        get() = field.capitalize()//12.8
        private set(value) {//12.12
            field = value.trim()//12.9
        }

    var healthPoint = 89
    val isBlessed = true
    private val isImmortal = false //12.16-17 refactoring

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoint > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus() =
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

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")//12.3
}
