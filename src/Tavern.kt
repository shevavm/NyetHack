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
    var beverage = readLine()

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
}