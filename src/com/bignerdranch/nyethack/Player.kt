package com.bignerdranch.nyethack

import java.io.File
import java.lang.reflect.Array.get


class Player(
    _name: String,
    var healthPoint: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {
    var name = _name
        //12.5//12.10
        get() = "${field.capitalize()} of $hometown}"//12.8
        private set(value) {//12.12
            field = value.trim()//12.9
        }
    val hometown by lazy { selectHometown() }

    init {
        require(healthPoint > 0, { "healthPoint must be greater thah zero." })
        require(name.isNotBlank(), { "Player must have a name." })
    }

    constructor(name: String) : this(
        name,
        isBlessed = true,
        isImmortal = false
    ) {
        if (name.toLowerCase() == "kar") healthPoint = 40
    }

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

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
}
