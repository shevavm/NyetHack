const val TAVERN_NAME = "Taernyl's Folly"//7.1

//6.1
fun main(args: Array <String>) {
    /*6.2 var signatureDrink = "Buttered Ale"
    signatureDrink = null*/
//    var beverage = readLine()?.capitalize() //6.5 6.6 ?.
    /*var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    } //6.7 let */
    //var beverage = readLine()!!.capitalize() //6.8 !! 6.9
    /*var beverage = readLine()

// 6.4 Ctrl+/    beverage = null //6.3
    //beverage = null //6.7
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can`t do that without crashing - beverage was null!")
    } //6.8 6.9
//    println(beverage) 6.10
    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)*/
    //7.7 placeOrder("shandy, Dragon's Breath, 5.91")
    placeOrder("elixir, Shirley's Temple, 4.12")
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

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    /*val data = menuData.split(',')//7.3
    val type = data [0]
    val name = data [1]
    val price = data [2]*/
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    /*7.6 val phrase = "Ah, delicious $name!"
    println("Madrigal exclamims: ${toDragonSpeak(phrase)}")*/

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Tranks for the $name."
    }
    println(phrase)
}