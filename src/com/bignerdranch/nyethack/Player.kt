package com.bignerdranch.nyethack

import java.io.File
import com.bignerdranch.nyethack.extensions.random as randomizer

class Player(
    _name: String,
    override var healthPoint: Int = 100,
    val isBlessed: Boolean,
    private var isImmortal: Boolean
) : Fightable {
    var name = _name
        get() = "${field.capitalize()} $hometown"
        private set(value) {
            field = value.trim()
        }
    val hometown by lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)
    init {
        require(healthPoint > 0, { "healthPoint must be greater thah zero." })
        require(name.isNotBlank(), { "Player must have a name." })
    }

    constructor(name: String) : this(name, isBlessed = true, isImmortal = false) {
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
        .randomizer()
    //.random() 18.16
    //.shuffled() 18.15
    //.first()

    override val diceCount: Int = 3

    override val diceSides: Int = 6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoint -= damageDealt
        return damageDealt
    }//16.2-3
}
