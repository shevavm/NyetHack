//6.11
fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    try {
        proficiencyCheck(swordsJuggling)//6.13
        swordsJuggling = swordsJuggling!!.plus(1) //6.12
    } catch (e: Exception) {
        println(e) //6.16
    }
    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    //swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
    //swordsJuggling ?: throw UnskilledSwordJugglerException ()//6.15
    checkNotNull(swordsJuggling, { "Player cannot juggle swords" })//6.17
}//6.13

class UnskilledSwordJugglerException() :
    IllegalStateException("Player cannot juggle swords")//6.14