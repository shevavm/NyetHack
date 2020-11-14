package com.bignerdranch.nyethack

import kotlin.random.Random

interface Fightable {
    var healthPoint: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int
        get() = (0 until diceCount).map {
            Random().nextInt(diceSides + 1)
        }.sum()

    fun attack(opponent: Fightable): Int
}

annotation class Monster(
    val name: String,
    val description: String,
    override var healthPoint: Int
) : Fightable {
    override fun attack(opponent: Fightable): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val damageDealt = damageRoll
        opponent.healthPoint -= damageDealt
        return damageDealt
    }
}

class Goblin(
    name: String = "Goblin",
    description: String = "A nasty-looking goblin",
    healthPoint: Int = 30
) : Monster(name, description, healthPoint) {
    override val diceCount = 2
    override val diceSides = 8

}