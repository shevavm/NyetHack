package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"//7.1

/*11.6 8.1
var playerGold = 10
var playerSilver = 10
//10.10 val com.bignerdranch.nyethack.getPatronList = listOf("Eli","Mordoc","Sophie")//10.1 10.4 */
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")//10.24
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n") //10.17
//val com.bignerdranch.nyethack.getPatronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)//11.5
val patronGold = mutableMapOf<String, Double>()


//6.1
fun main(args: Array <String>) {
    /*6.2 var signatureDrink = "Buttered Ale"
    signatureDrink = null
//    var beverage = readLine()?.capitalize() //6.5 6.6 ?.
    var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    } //6.7 let
    //var beverage = readLine()!!.capitalize() //6.8 !! 6.9
    //var beverage = readLine()

// 6.4 Ctrl+/    beverage = null //6.3
    //beverage = null //6.7
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can`t do that without crashing - beverage was null!")
    } //6.8 6.9
//    println(beverage) 6.10
    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
    //7.7 com.bignerdranch.nyethack.placeOrder("shandy, Dragon's Breath, 5.91")
    //8.1 com.bignerdranch.nyethack.placeOrder("elixir, Shirley's Temple, 4.12")*/
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back plaing cards.")
    } else {
        println("The tavern master  says: Eli isn't here.")
    }
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master  says: Nay, they departed hours ago.")
    }
    /*//com.bignerdranch.nyethack.placeOrder("shandy, Dragon's Breath, 5.91")
    //println(com.bignerdranch.nyethack.getPatronList[0])//10.4 10.10
    //println(com.bignerdranch.nyethack.getPatronList)
    com.bignerdranch.nyethack.getPatronList.remove("Eli")
    com.bignerdranch.nyethack.getPatronList.add("Alex")
    com.bignerdranch.nyethack.getPatronList.add(0, "Alex")//10.11
    com.bignerdranch.nyethack.getPatronList[0] = "Alexis"//10.12
    println(com.bignerdranch.nyethack.getPatronList)
    for (patron in com.bignerdranch.nyethack.getPatronList) {
        println("Good evening, $patron")
    }
    com.bignerdranch.nyethack.getPatronList.forEachIndexed{index, patron -> //10.15
        println("Good evening, $patron - you're #${index + 1} in line.")
        com.bignerdranch.nyethack.placeOrder(patron, com.bignerdranch.nyethack.getMenuList.shuffled().first())//10.19
    }

    com.bignerdranch.nyethack.getMenuList.forEachIndexed {index, data ->
        println("$index : $data")
    }//10.24*/

    (0..9).forEach {
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
        //println(name) 10.25
        uniquePatrons += name
    }
    //11.5println(com.bignerdranch.nyethack.getUniquePatrons)
    uniquePatrons.forEach { patronGold[it] = 6.0 }

    var orderCount = 0 //10.26
    while (orderCount <= 9) {
        placeOrder(
            uniquePatrons.random(),
            menuList.random()
        )
        orderCount++
    }
    /*println(com.bignerdranch.nyethack.getPatronGold)//11.1
    println(com.bignerdranch.nyethack.getPatronGold["Eli"])
    println(com.bignerdranch.nyethack.getPatronGold["Mordoc"])
    println(com.bignerdranch.nyethack.getPatronGold["Sophie"])//11.4*/
    displayPatronBalances()//11.7

    patronList.forEach { patron ->
        //10.14
        println("Good evening, $patron")
    }
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}
/*fun com.bignerdranch.nyethack.performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0) //8.4
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")//8.5
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("com.bignerdranch.nyethack.Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}*/

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.") //10.16

    /*val data = menuData.split(',')//7.3
    val type = data [0]
    val name = data [1]
    val price = data [2]*/

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

    /*7.6 val phrase = "Ah, delicious $name!"
    println("Madrigal exclaims: ${com.bignerdranch.nyethack.toDragonSpeak(phrase)}")

    //com.bignerdranch.nyethack.performPurchase(price.toDouble())//8.1 8.3*/

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Tranks for the $name."
    }
    println(phrase)
}